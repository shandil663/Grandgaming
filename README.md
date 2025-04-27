# Cat Image Fetcher App

This project is an Android application created as part of an assignment for an Android Developer role. The app fetches cat images from an API and displays them in a RecyclerView. The app follows the **MVVM architecture** and implements best practices such as **clean code**, **separation of concerns**, and **Kotlin XML** for UI design. It uses **ViewModel**, **Repository**, and **LiveData** to manage data and ensure smooth UI interaction.

## Features
- Fetches cat images from an API and displays them in a **Grid** layout.
- **RecyclerView** to show the images.
- **Circular Progress Indicator** while the data is being fetched.
- Implements the **MVVM architecture** with proper separation between UI, business logic, and data.
- Error handling when API responses are unsuccessful.

## Libraries Used
- **Kotlin** for the programming language.
- **RecyclerView** to display images.
- **Glide** for image loading.
- **LiveData** for observing data changes.
- **ViewModel** for managing UI-related data lifecycle-consciously.
- **Retrofit** for making network calls.

## Project Structure
- **MVVM Architecture**:
  - **Model**: Contains data classes like `APIItemItem` representing the structure of the API response.
  - **View**: The `MainActivity` and its layout.
  - **ViewModel**: `CatImageViewModel` to manage UI-related data and handle the logic for fetching cat images.
  - **Repository**: `CatRepository` to manage the API data and return the result to the ViewModel.
  
## UI Design
The app uses **ConstraintLayout** for the main screen and a **GridLayoutManager** for displaying images in a grid format. A **CircularProgressIndicator** is used for loading animations.

## Screenshots
Here are a few screenshots of the app:
![G1](https://github.com/user-attachments/assets/d203b072-1a65-424e-b1c2-7af36f64ce79)
![G2](https://github.com/user-attachments/assets/8d13a7e2-6a23-4b85-a6d1-c110b2f88aba)


## Video Demo
https://drive.google.com/file/d/1kM9RJtDErc6iLfwEGC7ptWDpyfuByQc0/view?usp=sharing

## Setup Instructions

### Prerequisites
To run this project locally, ensure you have the following installed:
- Android Studio
- Kotlin plugin (for Android Studio)
- An Android emulator or a physical device to run the app

### Clone the Repository
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/shandil663/Grandgaming.git
