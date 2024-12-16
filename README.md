<img width="262" alt="Screenshot 2024-12-16 at 10 35 03 AM" src="https://github.com/user-attachments/assets/0771a856-8be3-4103-9901-77391f793f17" />

The Simple Weather App allows users to search for and display current weather information for any city, including temperature, humidity, wind speed, and more. It uses https://www.weatherapi.com/for retrieving weather data, Kotlin for development, Jetpack Compose for the user interface, Retrofit for network requests, Hilt for dependency injection, and follows the MVI design pattern along with Clean Architecture principles to keep the code modular and maintainable. The app also handles loading states and errors gracefully, ensuring a smooth user experience.

### Application Functions

1. **Search for Weather Data**
2. **Display Current Weather Information**
3. **Loading and Error Handling**

### Tech Stack Used

1. **Kotlin**
2. **Jetpack Compose**
3. **Retrofit**
4. **Hilt**
5. **ViewModel and LiveData**
6. **Coroutines**
7. **MVI (Model-View-Intent) Design Pattern**
8. **Clean Architecture**

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
### Future Development
1. **Fetch 7 Days of Weather Data:** Extend the app to include a 7-day weather forecast to provide users with more comprehensive weather information.

2. **Write Unit and UI Tests:** Enhance the app's reliability and maintainability by writing comprehensive unit and UI tests.

3. **Enhance User Experience:** Need to improve user experience.
