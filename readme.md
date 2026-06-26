# Skillforge Android App

Skillforge is a 3-screen Android learning app built as part of the **Clickretina Android Developer
Take-home Assessment**.

The goal of this assessment was to recreate the provided UI screens as accurately as possible while
building a clean, maintainable Android application using modern Android development practices and
AI-assisted development.

## Assessment Overview

This assignment required building a small learning app with the following flow:

**Home → Course Detail → Lesson Player**

### Screens

* **Home Screen**

    * Displays course categories
    * Shows popular courses
    * Search UI for courses/topics

* **Course Detail Screen**

    * Shows course thumbnail and metadata
    * Instructor information
    * Course lessons list

* **Lesson Screen**

    * Video player UI
    * Lesson description
    * Tabs (Lessons / Notes / Resources)
    * Lesson list

### Requirements

* Build using **Kotlin**
* Fetch data from provided API using **Retrofit + Coroutines**
* Load remote images using **Coil**
* Show loading and error states
* Write at least one unit test
* Use AI tools during development
* Submit public GitHub repository + debug APK

---

## API

Data is fetched from the provided JSON endpoint:

`https://raw.githubusercontent.com/android-assesment/notes/refs/heads/main/data.json`

The response contains nested data:

* Categories
* Courses
* Lessons

---

## Tech Stack

* **Kotlin**
* **Jetpack Compose**
* **MVVM + Clean Architecture**
* **Hilt** (Dependency Injection)
* **Retrofit**
* **Kotlin Coroutines**
* **Coil**
* **Navigation Compose**
* **JUnit** (Unit Testing)

---

## Project Structure

The project follows **Clean Architecture** principles:

* `data/` → API, repository implementation
* `domain/` → DTOs, Models, repository contracts, use cases
* `presentation/` → Screens, ViewModels, UI components
* `di/` → Hilt dependency injection modules

---

## How to Run the Project

### 1. Clone Repository

```bash
git clone <your-repo-url>
```

### 2. Add Base URL in `local.properties`

This project reads the API base URL from **BuildConfig**, which is populated using
`local.properties`.

Make sure your `local.properties` contains:

```properties
BASE_URL=https://raw.githubusercontent.com/
```

### 3. Sync Project

Open the project in **Android Studio** and sync Gradle.

### 4. Run App

Run the app on:

* Physical Android Device

Minimum recommended SDK: **Android 8+**

---

## BuildConfig Setup

The base URL is injected through Gradle and exposed via `BuildConfig`.

Example usage:

```kotlin
BuildConfig.BASE_URL
```

If `BASE_URL` is missing from `local.properties`, the app will fail to build or fetch API data
properly.

Please ensure this is configured before running the project.

---

## Features Implemented

✔ Home screen with categories and courses
✔ Course detail screen with instructor and lessons
✔ Lesson player UI
✔ Search functionality
✔ Tab selection (Lessons / Notes / Resources)
✔ Loading state
✔ Error handling
✔ Unit test

---

# AI Usage During Development

## AI Tools Used

* ChatGPT by [OpenAI](https://openai.com?utm_source=chatgpt.com) — Used for Jetpack Compose UI generation, debugging, architecture decisions, and code refactoring.
* [Google Stitch](https://stitch.withgoogle.com/?utm_source=chatgpt.com) — Used for generating and exporting screen designs.

## Example Prompts

* *“Generate this Jetpack Compose screen with all imports and preview. Split every section into separate composables.”*
* *“Make this search bar properly working using MVVM.”*
* *“Update the filtered list based on category name, course tags, or course name.”*
* *“Make this Jetpack Compose Row into proper clickable tab buttons with underline for selected tab.”*
* *“Help me refactor my Android app to follow clean architecture and SOLID principles.”*

## What AI Got Right

AI significantly helped speed up development by converting design references into Jetpack Compose code, breaking large screens into reusable composables, assisting with MVVM state management, search filtering logic, and debugging UI/state-related issues.

## What AI Got Wrong

AI-generated code was helpful but not always perfect. Common issues included slightly incorrect spacing, padding, alignment, minor color mismatches, layout issues in complex UI sections, and occasionally missing imports. In some cases, the generated functionality was also incorrect—for example, the lesson tabs were initially implemented as a simple row with underlined selected text instead of fully functional clickable tabs. Similarly, the search bar was generated as a static UI component without actual filtering logic or state handling.

## How I Fixed It

I manually refined the generated code by adjusting spacing, alignment, and colors to better match the intended design. For functionality issues, I provided additional context to the AI about the expected behavior—such as how lesson tab selection should update UI state and how the search bar should filter results dynamically through MVVM. I then integrated and refactored the generated code to ensure proper state management, maintainability, and clean architecture.

---

## Demo / APK

You can access the project deliverables here:

* **Debug APK**
* **Screen Recording**

Drive Link: [Google Drive Folder](https://drive.google.com/drive/u/0/folders/1ulwoTsNNyKoUZyT7G8FMLZIEejZoMpZI?q=sharedwith%3Apublic+parent%3A1ulwoTsNNyKoUZyT7G8FMLZIEejZoMpZI&utm_source=chatgpt.com)
