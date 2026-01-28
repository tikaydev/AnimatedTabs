# AnimatedTabs

A modern, highly interactive Android chat application template built with **Jetpack Compose**. This project showcases advanced animation techniques, custom UI components, and the new **Shared Element Transitions** for a fluid and polished user experience.

## ✨ Key Features

-   **Gooey Tab Navigation**: A custom-designed tab indicator that morphs and stretches as it slides between sections.
-   **Shared Element Transitions**: Seamlessly transition from list items to detail screens using the latest `SharedTransitionLayout` API.
-   **Interactive Search**: A playful search bar that expands with a jelly-like spring animation, shrinking other UI elements to make room.
-   **Ultra-Smoothed Shapes**: Custom `Shape` implementation for the tab indicator, utilizing Bézier curves for perfectly organic "gooey" edges.
-   **State Hoisting for Animations**: Smart handling of scroll positions and entrance animations to ensure list items remain static when returning from a detail screen.
-   **Clean Architecture**: Separation of concerns between domain models and presentation logic.

## 🛠 Tech Stack

-   **Kotlin**: 100% Kotlin codebase.
-   **Jetpack Compose**: For building the entire UI declaratively.
-   **Compose Animations**: Deep use of `animateContentSize`, `AnimatedContent`, `animateColorAsState`, and low-level spring physics.
-   **Shared Element API**: `ExperimentalSharedTransitionApi` for high-quality screen transitions.
-   **Material 3**: Utilizing modern Material Design components and theming.

## 🚀 Getting Started

### Prerequisites

-   Android Studio Jellyfish | 2023.3.1 or newer.
-   Android SDK Level 34 (Upside Down Cake).
-   A device or emulator running Android 8.0 (Oreo) or higher.

### Installation

1.  Clone the repository:
    ```bash
    git clone https://github.com/tikaydev/AnimatedTabs.git
    ```
2.  Open the project in **Android Studio**.
3.  Let the Gradle sync complete.
4.  Run the `app` module on your device or emulator.

## 📁 Project Structure

-   `presentation/screen/home`: Contains the `HomeScreen` and the complex Gooey Tab logic.
-   `presentation/screen/detail`: Contains the `ChatDetailScreen` with shared element transitions.
-   `presentation/component`: Reusable custom UI components like `BottomNavBar`, `MessageBubble`, and custom animations/shapes.
-   `domain/model`: Data models and dummy data for the application.
-   `App.kt`: The root navigation and state management hub.

## 👤 Credit
Original design and implementation by [Kyriakos Georgiopoulos](https://github.com/kyriakos-georgiopoulos).

## 📄 License

```text
Copyright 2026 Alex Tenkorang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
