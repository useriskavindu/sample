import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.preprocessing import MinMaxScaler
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import LSTM, Dense

# Sample dataset generation
data = {
    'Year': list(range(2015, 2025)) * 3,
    'Course': ['Computer Science'] * 10 + ['Data Science'] * 10 + ['Cybersecurity'] * 10,
    'Enrollment': [
        150, 170, 190, 210, 250, 280, 300, 320, 350, 370,
        80, 100, 120, 150, 180, 220, 260, 300, 350, 400,
        50, 70, 90, 110, 130, 160, 190, 220, 250, 280
    ]
}
df = pd.DataFrame(data)

# Pivot the data to create a time-series format
pivot_df = df.pivot(index='Year', columns='Course', values='Enrollment')
pivot_df = pivot_df.fillna(0)

# Normalize the data
scaler = MinMaxScaler()
scaled_data = scaler.fit_transform(pivot_df)

# Prepare data for LSTM model
X, y = [], []
for i in range(len(scaled_data) - 1):
    X.append(scaled_data[i])
    y.append(scaled_data[i + 1])
X, y = np.array(X), np.array(y)
X = np.reshape(X, (X.shape[0], 1, X.shape[1]))

# Build LSTM model
model = Sequential([
    LSTM(50, activation='relu', input_shape=(1, X.shape[2])),
    Dense(y.shape[1])
])
model.compile(optimizer='adam', loss='mse')

# Train the model
model.fit(X, y, epochs=100, verbose=1)

# Predict future trends (e.g., for 2025)
last_known_data = np.reshape(scaled_data[-1], (1, 1, X.shape[2]))
prediction = model.predict(last_known_data)
predicted_enrollments = scaler.inverse_transform(prediction)[0]

# Display the results
print("Predicted Enrollments for 2025:")
for course, pred in zip(pivot_df.columns, predicted_enrollments):
    print(f"{course}: {int(pred)} students")

# Plot historical and predicted trends
plt.figure(figsize=(10, 5))
for i, course in enumerate(pivot_df.columns):
    plt.plot(pivot_df.index, pivot_df[course], marker='o', label=f'{course} (Actual)')
    plt.scatter(2025, predicted_enrollments[i], color='red', label=f'{course} (Predicted)')
plt.xlabel("Year")
plt.ylabel("Enrollment Count")
plt.legend()
plt.title("Course Enrollment Trends Prediction")
plt.show()

# Additional detailed trend plots for each course
for course in pivot_df.columns:
    plt.figure(figsize=(8, 4))
    plt.plot(pivot_df.index, pivot_df[course], marker='o', linestyle='-', label=f'{course} (Actual)')
    plt.scatter(2025, predicted_enrollments[pivot_df.columns.get_loc(course)], color='red', label=f'{course} (Predicted)')
    plt.xlabel("Year")
    plt.ylabel("Enrollment Count")
    plt.legend()
    plt.title(f"Enrollment Trend for {course}")
    plt.show()
