# Number Base Converter

This is a number base converter project that converts numbers from base 2 to base 36. It is implemented in Java 17 and provides a command-line interface to perform conversions between different number bases.

## Installation

To use this number base converter, you need to have Java Development Kit (JDK) 17 or higher installed on your system. Follow the steps below to get started:

1. Clone this repository to your local machine.
   ```
   git clone https://github.com/Just3a3Cat12/Number-Base-Converter-Java.git
   ```

2. Change to the project directory.
   ```
   cd number-base-converter-java
   ```

## Usage

To run the number base converter, follow these steps:

1. Open a terminal or command prompt.

2. Navigate to the project directory.

3. Compile the Java source files.
   ```
   javac BaseConverter.java
   ```

4. Run the application.
   ```
   java BaseConverter
   ```

5. Enter two numbers in the following format: `{source base} {target base}`. For example, to convert from base 2 to base 10, enter `2 10`.

6. To convert a number, enter the number in base `{source base}`. For example, if the source base is 2, enter a binary number.

7. The application will display the converted number in the target base `{target base}`.

8. To go back to the base selection, type `/back`.

9. To exit the application, type `/exit`.

## Example

Here's an example of how to use the number base converter:

```
$ java NumberBaseConverter
Enter two numbers in format: {source base} {target base} (To quit type /exit)
2 10
Enter number in base 2 to convert to base 10 (To go back type /back)
10101
Conversion result: 21

Enter number in base 2 to convert to base 10 (To go back type /back)
101010
Conversion result: 42

Enter number in base 2 to convert to base 10 (To go back type /back)
/back
Enter two numbers in format: {source base} {target base} (To quit type /exit)
16 2
Enter number in base 16 to convert to base 2 (To go back type /back)
A9
Conversion result: 10101001

Enter number in base 16 to convert to base 2 (To go back type /back)
5F
Conversion result: 1011111

Enter number in base 16 to convert to base 2 (To go back type /back)
/exit
Goodbye!
```

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

## Acknowledgments
This project was inspired by the need to easily convert numbers between different bases. 

## Contact

If you have any questions or suggestions regarding this project, feel free to contact the maintainer at [ambekarpankaj@outlook.com](ambekarpankaj@outlook.com).
