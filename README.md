A layered Spring Boot REST API for managing astronauts and satellites. Supports creating astronauts with assigned satellites, updating satellites (unless decommissioned), and fetching astronaut data with clean DTOs, validation, and global exception handling.

🔹 Many-to-Many JPA relationship
🔹 Bean validation and error formatting
🔹 Clean architecture (Controller → Service → Repository)
🔹 H2 database with sample data
🔹 Tested via Postman

## 📸 Screenshots

### 1. Create Astronaut (Postman)
![Create Astronaut](createAstonaut.png)

### 2. Get All Astronauts (Sorted)
![Get Astronauts](getAllAstronaut)

### 3. Error - Decommissioned Satellite Update
![Error - Satellite Decommissioned](exceptionWithDecommisioned)

### 4. Update Satellite
![Get Astronauts](updateSatellite)
