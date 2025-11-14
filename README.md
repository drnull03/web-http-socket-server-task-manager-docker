# Notes and Changes from the Original Project

Before executing the tasks, the following changes were made:

1. Reverse-engineered the entire project because Medium has a paywall for the original article.
2. Added comments throughout the project to reflect code understanding.
3. Changed the Dockerfile to run `WebServerHttp` instead of the socket server because it is cleaner.

---

# Steps to Run the Project

1. **Edit the base image** in the Dockerfile (the original image no longer exists). Replace with:

    ```dockerfile
    FROM eclipse-temurin:8-jdk-alpine
    ```

2. **Build the Docker image** from the Dockerfile:

    ```bash
    docker build --network=host -t executor-server .
    ```

3. **Run a container** from the image:

    ```bash
    docker run --network=host --name executor-server-container -d executor-server
    ```

4. **Alternative:** Use the provided bash script instead of the first three steps:

    ```bash
    ./updateContainer.sh
    ```

---

# The Two Tasks Added

1. **TaskWeather**  
   - Gives the weather for Damascus, Syria.  
   - Example: "It is super cold today lol."

2. **TaskPalindrome**  
   - Checks if a given string is a palindrome.  
   - Example: `"WWTWW"` → palindrome.

---

# How to Call the New Tasks

You can use the `requests.rest` file with the **VS Code REST Client extension**. Examples:

### TaskWeather

```http
POST http://localhost:8000
Content-Type: application/x-www-form-urlencoded

TaskWeather&5
```
---
```
POST http://localhost:8000
Content-Type: application/x-www-form-urlencoded

TaskPalindrome&WWTWW
