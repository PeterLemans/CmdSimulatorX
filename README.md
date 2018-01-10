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

# File contains the key as command and other parameters.
"COMMAND","OUTPUT","RESULT","ERROR","SYSTEMRC"

"pwd","/root","","","0"
