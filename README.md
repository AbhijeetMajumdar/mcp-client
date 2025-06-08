- This is a Spring AI Model Context Server. It is integrating the Ollama to another RESTa pi project [custom-mcp](https://github.com/AbhijeetMajumdar/custom-mcp)
- Install Ollama LLM as per your machine configuration.
- I used Install llama3.2:1b from [Ollama](https://ollama.com/)
- Git Clone  [custom-mcp](https://github.com/AbhijeetMajumdar/custom-mcp) project.
- Windows 11 comand will help to kill daemon custom-mcp process.
- netstat -aon | findstr :8060
- taskkill /pid 20740 /fcurl

Example
- curl --location 'http://localhost:8080/api/chat' --header 'Content-Type: application/json' --data '{"message" : "What is the latest AAPL price?"}'
- curl --location 'http://localhost:8080/api/chat' --header 'Content-Type: application/json' --data '{"message" : "What is today's date?"}'
- curl --location 'http://localhost:8080/api/chat' --header 'Content-Type: application/json' --data '{"message" : "Show my Chase account 123456 holdings."}'  
