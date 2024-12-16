<img width="262" alt="Screenshot 2024-12-16 at 10 35 03 AM" src="https://github.com/user-attachments/assets/0771a856-8be3-4103-9901-77391f793f17" />

The Simple Weather App allows users to search for and display current weather information for any city, including temperature, humidity, wind speed, and more. It uses https://www.weatherapi.com/for retrieving weather data, Kotlin for development, Jetpack Compose for the user interface, Retrofit for network requests, Hilt for dependency injection, and follows the MVI design pattern along with Clean Architecture principles to keep the code modular and maintainable. The app also handles loading states and errors gracefully, ensuring a smooth user experience.

### Application Functions

1. **Search for Weather Data**:
   - Users can enter a city name to retrieve current weather information.
   - The search functionality is responsive and provides results quickly.

2. **Display Current Weather Information**:
   - Shows detailed weather data including temperature, humidity, wind speed, UV index, and precipitation.
   - Displays weather conditions with appropriate icons and descriptions.
   - Provides location details such as city name and country.

3. **Loading and Error Handling**:
   - Shows a loading indicator while fetching data from the weather API.
   - Handles errors gracefully by displaying user-friendly error messages if data retrieval fails.

### Tech Stack Used

1. **Kotlin**:
   - Primary programming language for Android development.

2. **Jetpack Compose**:
   - Used for building the UI in a declarative way, ensuring a modern and responsive user experience.

3. **Retrofit**:
   - For making network requests to the weather API.

4. **Hilt**:
   - Dependency Injection framework that simplifies the management of dependencies, making the code more modular and easier to test.

5. **ViewModel and LiveData**:
   - Part of Android Architecture Components, used to manage UI-related data in a lifecycle-aware manner.

6. **Coroutines**:
   - For handling asynchronous tasks like network calls, ensuring smooth and responsive UI.

7. **MVI (Model-View-Intent) Design Pattern**:
   - Ensures clear separation of concerns, making the app more maintainable and testable.

8. **Clean Architecture**:
   - Organizes the code into different layers (data, domain, presentation), promoting a modular and scalable architecture.

### Package Structure

The project is organized into a clean and maintainable package structure:

```
com.example.simpleweatherapp
├── data
│   ├── di
│   │   └── AppModule.kt
│   ├── model
│   │   ├── ConditionDto.kt
│   │   ├── CurrentDto.kt
│   │   ├── LocationDto.kt
│   │   └── WeatherModelDto.kt
│   ├── repository
│   │   ├── WeatherRepository.kt
│   │   └── WeatherRepositoryImpl.kt
│   └── api
│       ├── Constants.kt
│       ├── NetworkResponse.kt
│       ├── RetrofitInstance.kt
│       └── WeatherAPI.kt
├── domain
│   ├── model
│   │   ├── Condition.kt
│   │   ├── Current.kt
│   │   ├── Location.kt
│   │   └── WeatherModel.kt
│   ├── repository
│   │   └── WeatherRepository.kt
│   └── usecase
│       └── GetWeatherUseCase.kt
├── presentation
│   ├── ui
│   │   └── WeatherPage.kt
│   │   └── WeatherDetails.kt
|   |   └── WeatherState.kt
|   |   └── WeatherAction.kt
│   └── viewmodel
│       └── WeatherViewModel.kt
├── mapper
│   └── WeatherModelMapper.kt
└── utils
    └── NetworkResponse.kt

```

