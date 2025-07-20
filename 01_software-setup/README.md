# Java Development Environment Setup

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://adoptium.net/)
[![VS Code](https://img.shields.io/badge/VS%20Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)](https://code.visualstudio.com/)
[![Extension Pack](https://img.shields.io/badge/Extension%20Pack-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

This guide will help you set up a professional Java development environment using Visual Studio Code (VS Code) as your Integrated Development Environment (IDE).

## Prerequisites

- A computer running Windows, macOS, or Linux
- Internet connection for downloading software
- Basic familiarity with using a computer

## Quick Start

1. [Install Java](#java-installation)
2. [Install VS Code](#vs-code-installation)
3. [Install Java Extensions](#java-extensions)
4. [Verify Setup](#verify-setup)

## Java Installation

### Windows
1. Visit [Eclipse Temurin](https://adoptium.net/) or [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
2. Download the latest LTS version for Windows
3. Run the installer and follow the setup wizard
4. Verify installation by opening Command Prompt and running:
   ```bash
   java --version
   javac --version
   ```

### macOS
1. **Option 1 - Homebrew (Recommended):**
   
   **First, install Homebrew if you don't have it:**
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```
   
   **Then install Java:**
   ```bash
   brew install --cask temurin
   ```
   
2. **Option 2 - Manual Installation:**
   - Visit [Eclipse Temurin](https://adoptium.net/)
   - Download the macOS installer (.pkg file)
   - Run the installer and follow the setup wizard

3. Verify installation:
   ```bash
   java --version
   javac --version
   ```

### Linux (Ubuntu/Debian)
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### Linux (Fedora/RHEL/CentOS)
```bash
sudo dnf install java-17-openjdk-devel
```

## VS Code Installation

### Download and Install
1. Visit [Visual Studio Code](https://code.visualstudio.com/)
2. Download the appropriate version for your operating system
3. Run the installer and follow the setup wizard

### First Launch Setup
1. Launch VS Code
2. Install the **Java Extension Pack** (recommended for beginners)
3. Configure your preferred theme and settings

## Java Extensions

### Essential Extensions
Install these extensions in VS Code for the best Java development experience:

1. **Extension Pack for Java** - All-in-one Java development
   - Search for: `vscjava.vscode-java-pack`
   - Includes: Language Support, Debugger, Test Runner, Maven, Project Manager

2. **Language Support for Java by Red Hat**
   - Provides IntelliSense, syntax highlighting, and error detection

3. **Debugger for Java**
   - Enables debugging Java applications

4. **Java Test Runner**
   - Run and debug JUnit tests

5. **Maven for Java**
   - Maven project support and dependency management

### Installing Extensions
1. Open VS Code
2. Press `Ctrl+Shift+X` (Windows/Linux) or `Cmd+Shift+X` (macOS)
3. Search for each extension by name
4. Click "Install" for each extension

## Verify Setup

### Test Java Installation
1. Open a terminal/command prompt
2. Run the following commands:
   ```bash
   java --version
   javac --version
   ```
3. You should see version information for both commands

### Test VS Code Java Setup
1. Create a new folder for your Java projects
2. Open the folder in VS Code
3. Create a new file named `HelloWorld.java`
4. Add the following code:
   ```java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello, World!");
       }
   }
   ```
5. Save the file
6. Press `F5` to run the program
7. You should see "Hello, World!" in the debug console

## Running Java Code in VS Code

### Method 1: Using the Run Button
1. Open your Java file
2. Click the "Run" button (▶️) in the top-right corner
3. Select "Run Java" when prompted

### Method 2: Using F5 (Debug)
1. Set breakpoints by clicking in the left margin
2. Press `F5` to start debugging
3. Use the debug toolbar to step through code

### Method 3: Using Terminal
1. Open the integrated terminal (`Ctrl+`` ` or `Cmd+`` `)
2. Compile: `javac HelloWorld.java`
3. Run: `java HelloWorld`

## Debugging Java Code

### Setting Breakpoints
1. Click in the left margin next to line numbers
2. A red dot will appear indicating a breakpoint
3. Press `F5` to start debugging

### Debug Controls
- **Continue (F5)**: Continue execution until next breakpoint
- **Step Over (F10)**: Execute current line and move to next
- **Step Into (F11)**: Step into method calls
- **Step Out (Shift+F11)**: Step out of current method
- **Restart (Ctrl+Shift+F5)**: Restart debugging session
- **Stop (Shift+F5)**: Stop debugging

### Debug Console
- View variable values
- Execute expressions
- Monitor program state

## Troubleshooting

### Common Issues

**Java not found:**
- Ensure Java is installed and added to PATH
- Restart VS Code after Java installation
- Check environment variables

**Extensions not working:**
- Reload VS Code (`Ctrl+Shift+P` → "Developer: Reload Window")
- Check extension installation status
- Update VS Code to latest version

**Compilation errors:**
- Check Java syntax
- Ensure file extension is `.java`
- Verify class name matches file name

### Getting Help
- Check the [VS Code Java documentation](https://code.visualstudio.com/docs/languages/java)
- Visit the [Java Extension Pack page](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- Review [Eclipse Temurin documentation](https://adoptium.net/docs/)

## Additional Resources

- [VS Code Java Tutorial](https://code.visualstudio.com/docs/java/java-tutorial)
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [JUnit Testing](https://junit.org/junit5/)

## Contributing

If you find any issues or have suggestions for improving this setup guide, please:

1. Check existing issues
2. Create a new issue with detailed description
3. Fork the repository and submit a pull request

---


*This setup guide is designed for CS105 students but can be used by anyone learning Java development.*