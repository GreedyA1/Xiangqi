# Xiangqi 

[![Build Status](https://travis-ci.org/GreedyAlchemist/Xiangqi.svg?branch=master)](https://travis-ci.org/GreedyAlchemist/Xiangqi)

Xiàngqí is a game of strategy that is similar to the game that we know as chess. It has a different type of board and pieces that are similar to standard chess pieces, but with quite different rules.



## Getting Started

Download the whole Eclipse project from github.

The project contains different versions of the game. Alpha, Beta, Gamma, Delta in Increasing order of complexity. 

### Versions

Alpha   Alpha Xiàngqí is a version of the game to get started on developing the game with the supplied code base. 
![Alpha Xiangqi](images/AlphaXiangqi.PNG?raw=true "Alpha")

Beta    Xiàngqí adds a little bit more capability to the game. The board consists of 4 x 4 squares, yielding a 5 x 5 playing space.
![Beta Xiangqi](images/BetaXiangqi.PNG?raw=true "Beta")

Gamma	Xiàngqí is the first version that uses the standard board, including the River and the Generals’ palaces.
![Gamma Xiangqi](images/Xiangqi.PNG?raw=true "Gamma")

Delta   Xiàngqí is the full version of the game.
![Delta Xiangqi](images/XiangqiBoard.PNG?raw=true "Delta")



### Prerequisites

* [Eclipse](https://www.eclipse.org/downloads/) - IDE for java.
* [JRE 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) - Java Developement Environment or Developent Kit.

### Build

To start the server run the server.java file from Eclipse. 
After the server is running you need to make sure 5566 port is open on your machine and is not blocked by firewall.
After starting the server each client should run the Client.java file. 
After running the file client can choose their name and login to the server with specified IP address by clicking the connect button.


## Authors

* **Vakhtang Margvelashvili** 

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.