### 1. Install Ollama
- Go to the [Ollama website](https://ollama.com/) and download Ollama for your operating system.
- Follow the instructions to install Ollama on your machine.

### 2. Install the Required Model
- For this project, install the llama3.2:1b model:
  ```
  ollama pull llama3.2:1b
  ```
  (Replace with the specific command for your model and Ollama version if needed.)

### 3. Clone the Repositories
- Clone this project (`mcp-client`):
  ```bash
  git clone https://github.com/AbhijeetMajumdar/mcp-client
  ```
- Clone the supporting REST API project (`custom-mcp`):
  ```bash
  git clone https://github.com/AbhijeetMajumdar/custom-mcp
  ```

### 4. Start Both Services
- Make sure both Ollama and the custom-mcp server are running.
- Start the Spring AI Model Context Server (`mcp-client`) as you would a standard Spring Boot application (e.g., using `mvn spring-boot:run` or via your IDE).

### 5. Managing Processes (Windows)
If you need to terminate the custom-mcp process (for example, if it’s using port 8060), you can do the following in Windows:
```bash
netstat -aon | findstr :8060
```
Find the PID (e.g., 20740), then:
```bash
taskkill /pid 20740 /f
```

### 6. Test the API
Use curl to test the API endpoints:
```bash
curl --location 'http://localhost:8080/api/chat' --header 'Content-Type: application/json' --data '{"message" : "What is the latest AAPL price?"}'
curl --location 'http://localhost:8080/api/chat' --header 'Content-Type: application/json' --data '{"message" : "What is today's date?"}'
curl --location 'http://localhost:8080/api/chat' --header 'Content-Type: application/json' --data '{"message" : "Show my Chase account 123456 holdings."}'
```

---

Let me know if you need the setup steps for a specific OS or have questions about configuration!
