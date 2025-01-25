# BrainJuck Interpreter

BrainJuck Interpreter is a Java-based interpreter for the Brainfuck programming language. It is a simple command-line utility that reads Brainfuck code and executes it, producing output according to the program's behavior.

## Getting Started

### Prerequisites

In order to use the BrainJuck Interpreter, you will need to have the following installed on your machine:

- Java Development Kit (JDK) version 8 or later
- Maven
- Git (optional, for cloning the repository)

### Installation

To install the BrainJuck Interpreter, you can follow these steps:

1. Clone the repository (optional):
   
Alternatively, you can download the source code as a ZIP file and extract it to a directory of your choice.

```
https://github.com/ManishDait/BrainJuck.git
```

2. Build the project:

Navigate to the `brainjuck` directory and run the following command to build the project:

```
mvn clean compile assembly:single
```

3. Alternatively, you can user .deb file in `release` folder:

You can install it directly using the package manager of your Linux distribution. For example, if you're using `apt`:

```
sudo apt install /path/to/brainjuck.deb
```

### Usage
1. To run the BrainJuck Interpreter with .jar, you can use the following command:

```
java -jar target/brainjuck-jar-with-dependencies.jar <filename>
```

where `<filename>` is the path to the Brainfuck code file you want to execute.

For example, to run a program stored in `example.bf`, you would run the following command:

```
java -jar target/brainjuck-jar-with-dependencies.jar example.bf
```

2. To run the BrainJuck Interpreter with .deb, you can use the following command:
```
brainjuck <filename>
```
where `<filename>` is the path to the Brainfuck code file you want to execute.

For example, to run a program stored in `example.bf`, you would run the following command:
```
brainjuck example.bf
```





## Features

`Brainjuck Interpreter` provides the following features:

- Executes `Brainfuck` programs written in a file
- Supports all `Brainfuck` instructions (`+`, `-`, `>`, `<`, `[`, `]`, `.`, and `,`)


## License

The BrainJuck Interpreter is licensed under the MIT License. See the `LICENSE` file for more information.
