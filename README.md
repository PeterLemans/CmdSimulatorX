# CmdSimulatorX

This project is used to simulate command execution.

CmdSimulatorX offers a few key features:  
- This tool can be used as a test harness to simulate command execution (mock command execution).
- This tool can help to test automation tool/orchestrator mimic command execution on the target servers.
- Each command can have multiple output options with system error codes. Very useful for doing complete success and error flow testing.

## Maven Installation
Run mvn clean install

## Usage

usage: Command Simulator X
 -c,--command <arg>    command
 -f,--yamlFile <arg>   yamlFile

## Example

$java -jar CmdSimulatorX.jar -c "df /root |tr -s ' ' |cut -d' ' -f5|tail -n1" -f  ExecuteCommandX.yaml
Output: 
90%

## File contains the key(command) and other parameters.
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
## Contributing
 
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D
 
## Credits
 
Lead Developer - Deed Singh (@deedsingh88)

 
## License
 
The MIT License (MIT)

Copyright (c) 2017 Deed Singh

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
