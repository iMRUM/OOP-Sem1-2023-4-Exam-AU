# Flight Search System

## Project Overview

This project implements a flight search system using various Object-Oriented Programming (OOP) principles and design patterns. It includes functionality to search for flights based on different criteria, manage airlines and flights hierarchically, and notify users of changes using the Observer pattern.

## Design Patterns Used

1. **Strategy Pattern**
   - Used for implementing different flight search algorithms.
   - Interface: `ISearchAlgo`
   - Implementations: 
     - `SearchAlgoByAirline`
     - `SearchAlgoByDestination`
     - `SearchAlgoByDuration`
     - `SearchAlgoByPrice`
     - `SearchAlgoByTime`

2. **Composite Pattern**
   - Used for building a hierarchical model of airlines and flights.
   - Interfaces: `IComponent`, `IContainer`
   - Implementations:
     - `AbstractContainer`
     - `AirlineManager`
     - `AbstractAirline`
     - `ConcreteAirline`
     - `ConcreteSubsidiaryAirline`

3. **Observer Pattern**
   - Used for implementing a notification system for flight updates.
   - Interfaces: `IPublisher`, `ISubscriber`
   - Implementations:
     - `AbstractPublisher`
     - `AbstractSubscriber`
     - `Flight`
     - `Passenger`
     - `Employee`

4. **Factory & Flyweight Patterns**
   - Used for creating and managing reusable instances of various entities.
   - Interface: `IProduct`
   - Implementations:
     - `Factory`
     - `Flight`
     - `ConcreteAirline`
     - `ConcreteSubsidiaryAirline`
     - `Employee`
     - `Passenger`

5. **Singleton Pattern**
   - Used to ensure only one instance of the `EnrollmentSystem` exists.
   - Implementation: `EnrollmentSystem`

6. **State Pattern**
   - Used for managing different states of the enrollment system.
   - Interface: `IState`
   - Implementations:
     - `AbstractState`
     - `StartupState`
     - `StudentState`
     - `ProfessorState`
     - `LecturerState`

7. **Facade Pattern**
   - Used to provide a simplified interface to the complex subsystem of the enrollment system.
   - Implementation: `EnrollmentSystemFacade`



