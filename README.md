# CmdSimulatorX
This project is used to simulate command execution.

# Maven Installation
Run mvn clean install

# Usage
usage: Command Simulation Test Harness

-c,--command <arg>   command

-f,--csvFile <arg>   csvFile

# Example
$java -jar /CommandExecutionSimulation/commandSimulator.jar -c pwd -f  CommandExecutionSimulation/linux.csv
Output: 
/root

# File contains the key(command) and other parameters.
```
df /root |tr -s ' ' |cut -d' ' -f5|tail -n1:
  Name: Disk Utilization Linux
  Description: Simulate High Disk Space Utilization on Linux
  Command: df /root |tr -s ' ' |cut -d' ' -f5|tail -n1
  ExecuteKey: 0
  SimulationEnabled: true
  Values:
    0: {Output: 90%, Result: null, SystemRC: 0, Error: null}
    1: {Output: 40%, Result: null, SystemRC: 0, Error: Sample Error}
service httpd status:
  Name: Service Status Linux
  Description: Simulate Service Stop Start on Linux
  Command: service httpd status
  ExecuteKey: 1
  SimulationEnabled: true
  Values:
    0: {Output: httpd is stopped, Result: null, SystemRC: 3, Error: null}
    1: {Output: httpd (pid  2166) is running..., Result: null, SystemRC: 0, Error: null}
```
