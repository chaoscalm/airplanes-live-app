# Testing Guidelines

## What To Test

- **DO** write tests for anything related to **web APIs**
- **DO** write tests for data that is **serialized and stored** (to avoid breaking user data)

## What NOT To Test

- **Do NOT** create tests for the UI layer

## Test Stack

- JUnit5 (Jupiter) for unit tests
- Kotest for assertions
- MockK for mocking
- MockWebServer for HTTP endpoint testing

## Running Tests

```bash
# Local testing - use FOSS debug flavor
./gradlew testFossDebugUnitTest

# Other variants
./gradlew testGplayDebugUnitTest
```
