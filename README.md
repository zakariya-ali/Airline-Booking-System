# Airline Booking System

A simple Java application that simulates an airline flight allocation system. It
manages a fleet of aircraft, schedules flights, processes passenger bookings
(with upgrade/downgrade logic), handles crew assignments, and calculates takeoff
weights.

## Features

- **Fleet Management**: Define aircraft with make, model, tail number, weights,
  and seat layout.
- **Flight Scheduling**: Create flights with assigned aircraft, routes, and
  distances.
- **Passenger Booking**: Book passengers in first or economy class, with
  graceful handling of upgrades/downgrades and full-flight scenarios.
- **Crew Assignment**: Read crew member data from files and assign to
  corresponding flights.
- **Weight Calculation**: Calculate and validate takeoff weight including
  aircraft, passengers, and crew.
- **Error Handling**: Gracefully handles missing layout or data files without
  crashing the system.

## Project Structure

```
Airline Booking System/
├── 293Seats.txt            # Seat layout file for 293-seat aircraft
├── 387Seats.txt            # Seat layout file for 387-seat aircraft
├── flight1.txt             # Passenger & crew data for flight #1
├── flight2.txt             # Passenger & crew data for flight #2
├── ...
├── flight8.txt             # Passenger & crew data for flight #8
├── src/                    # Java source files
│   ├── Aircraft.java       # Aircraft model & properties
│   ├── CrewMember.java     # Crew member representation
│   ├── Flight.java         # Flight scheduling, seat allocation, weight logic
│   ├── GeneratePassengers.java # (Optional) utility to generate passenger data
│   ├── Passenger.java      # Passenger representation
│   ├── Person.java         # Base class for Passenger & CrewMember
│   ├── Q1Main.java         # Entry point: loads fleet, schedules flights, processes data
│   └── Seat.java           # Seat representation with class and allocation
└── README.md               # This file
```

## Data Files

- **Seat Layouts** (`*.txt`): CSV files where each row represents a row of
  seats. Values are `F` for first class or `E` (or any non-`F`) for economy.
  Used by `Flight` to initialize seat objects.
- **Passenger & Crew Data** (`flightN.txt`): Each line represents either a
  passenger or crew member:
  - Passenger line: `passenger,Name,Weight,Class,Age` (e.g.,
    `passenger,John Doe,85,first,32`)
  - Crew line: `crew,Name,Age` (e.g., `crew,Jane Smith,29`)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command-line terminal or IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Compilation

1. Open a terminal in the project root directory.
2. Create an output directory for compiled classes (e.g., `bin`).

   ```bash
   mkdir bin
   ```

3. Compile all Java files:

   ```bash
   javac -d bin src/*.java
   ```

### Running

Run the main class (`Q1Main`) from the `bin` directory:

```bash
java -cp bin Q1Main
```

Output will display:

- Initialization of fleet and flights.
- Booking confirmations, upgrades/downgrades, and full-flight notices.
- Final flight summaries with takeoff weight validation.

## Code Components

- **Q1Main.java**: Application entry point. Builds the fleet, schedules flights,
  processes passenger & crew files, and prints summaries.
- **Aircraft.java**: Represents an aircraft's make, model, tail number, weights,
  and associated seat layout file.
- **Flight.java**: Handles reading the layout file to create `Seat` objects,
  booking logic, crew list, and takeoff weight calculation.
- **Seat.java**: Represents a seat in either "first" or "economy" class, with an
  optional `Passenger` allocation.
- **Person.java**: Abstract base class for weight calculation shared by
  passengers and crew.
- **Passenger.java**: Extends `Person`, holds booking-specific attributes like
  class, weight, and age.
- **CrewMember.java**: Extends `Person`, holds crew-specific attributes.
- **GeneratePassengers.java**: Utility (if provided) to programmatically
  generate passenger files for testing.

## Customizing & Extending

- **Adding Aircraft Models**: Create new layout files (e.g., `150Seats.txt`) and
  add `fleet.add(...)` entries in `Q1Main.java`.
- **New Flights**: Modify or add `flights.add(...)` calls with desired route and
  distance.
- **Passenger Data**: Edit existing `flightN.txt` files or add new ones; ensure
  the main loop in `Q1Main` references them.

## Contributing

1. Fork the repository.
2. Create a feature branch: `git checkout -b feature/YourFeature`
3. Commit your changes: `git commit -m "Add your feature"`
4. Push to the branch: `git push origin feature/YourFeature`
5. Open a pull request.

## License

This project is released under the MIT License. See [LICENSE](LICENSE) for
details.

---
