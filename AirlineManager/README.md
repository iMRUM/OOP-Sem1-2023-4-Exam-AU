---

# AirlineManager

AirlineManager is a Java-based project demonstrating the implementation of software design patterns such as Composition, Factory, Observer, and Strategy. It showcases object-oriented programming principles, design pattern usage, and a modular architecture for managing an airline system. This project is developed as part of a Computer Science curriculum and is intended to demonstrate proficiency in Java, design patterns, and software engineering principles.

## Features

- **Composition Pattern**: Manages hierarchical relationships between airline components like flights, airlines, and subsidiary airlines.
- **Factory Pattern**: Creates various airline-related products using an abstract factory.
- **Observer Pattern**: Tracks and notifies changes in the airline system (e.g., employee or passenger notifications).
- **Strategy Pattern**: Implements flexible search algorithms for finding flights based on different criteria (e.g., price, time, duration, destination).

## Project Structure

The project is divided into four key modules:

1. **Composition**
   - Handles hierarchical relationships using interfaces and abstract classes.
   - Key Classes:
     - `ConcreteAirline`
     - `ConcreteSubsidiaryAirline`
     - `Flight`
     - `AbstractAirline`
     - `IComponent` (interface)
     - `IContainer` (interface)

2. **Factory**
   - Implements the Factory pattern to create airline-related products dynamically.
   - Key Classes:
     - `Factory`
     - `IProduct` (interface)

3. **Observer**
   - Implements the Observer pattern for publish-subscribe notifications.
   - Key Classes:
     - `AbstractPublisher`
     - `AbstractSubscriber`
     - `AbstractUser`
     - `Employee`
     - `Passenger`
     - `IPublisher` (interface)
     - `ISubscriber` (interface)

4. **Strategy**
   - Provides various search algorithms for flight management.
   - Key Classes:
     - `ISearchAlgo` (interface)
     - `SearchAlgoByAirline`
     - `SearchAlgoByDestination`
     - `SearchAlgoByDuration`
     - `SearchAlgoByPrice`
     - `SearchAlgoByTime`
     - `SearchService`

5. **Main**
   - Entry point of the application to demonstrate the functionality of all modules.

## Technologies Used

- **Programming Language**: Java
- **Design Patterns**: Composition, Factory, Observer, Strategy
- **Object-Oriented Principles**: Abstraction, Encapsulation, Inheritance, Polymorphism

## How to Run

1. Clone the repository:
   ```bash
      git clone -n --depth=1 --filter=tree:0 \
      https://github.com/iMRUM/OOP-Sem1-2023-4-Exam-AU
      cd OOP-Sem1-2023-4-Exam-AU
      git sparse-checkout set --no-cone AirlineManager
      git checkout

   ```

2. Compile the project:
   ```bash
   javac -d bin src/**/*.java
   ```

3. Run the main application:
   ```bash
   java -cp bin Main
   ```

## Key Highlights

- **Real-world Application**: Simulates a complex system for airline management.
- **Modular Design**: Well-organized codebase with reusable components.
- **Flexible Algorithms**: Search functionality adaptable to various criteria.

## Learning Outcomes

- Mastery of core Java programming concepts.
- Practical experience in implementing software design patterns.
- Hands-on exposure to building modular, maintainable, and extensible systems.

## About the Author

I am a Computer Science student with a strong foundation in object-oriented programming and design principles. This project represents my ability to design and implement scalable software systems using modern development practices.

## License

This project is open-source and available under the [MIT License](LICENSE).

---
