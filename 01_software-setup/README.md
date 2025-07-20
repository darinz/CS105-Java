# Java Development Environment Setup

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://adoptium.net/)
[![VS Code](https://img.shields.io/badge/VS%20Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)](https://code.visualstudio.com/)
[![Extension Pack](https://img.shields.io/badge/Extension%20Pack-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

This guide will help you set up a professional Java development environment using Visual Studio Code (VS Code) as your Integrated Development Environment (IDE). We'll walk through each step in detail, explaining what each tool does.

## Prerequisites

- A computer running Windows, macOS, or Linux
- Internet connection for downloading software
- Basic familiarity with using a computer
- Administrator access (you may need to enter your password during installation)

### What You'll Learn
By the end of this guide, you'll have:
- Java Development Kit (JDK) installed on your computer
- Visual Studio Code with Java extensions
- A working "Hello World" program
- Basic understanding of how to run and debug Java code

## Quick Start

1. [Install Java](#java-installation)
2. [Install VS Code](#vs-code-installation)
3. [Install Java Extensions](#java-extensions)
4. [Verify Setup](#verify-setup)

## Java Installation

**What is Java?**
Java is a programming language that runs on billions of devices. The Java Development Kit (JDK) includes everything you need to write, compile, and run Java programs.

### Windows
1. **Download Java:**
   - Visit [Eclipse Temurin](https://adoptium.net/) (recommended) or [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
   - Click on "Latest LTS Release" 
   - Select "Windows x64" from the dropdown
   - Download the `.msi` installer file

2. **Install Java:**
   - Double-click the downloaded `.msi` file
   - If Windows asks "Do you want to allow this app to make changes?", click "Yes"
   - Follow the installation wizard:
     - Click "Next" to proceed
     - Accept the license agreement
     - Choose installation location (default is fine)
     - Click "Install"
   - Wait for installation to complete
   - Click "Close" when finished

3. **Verify Installation:**
   - Press `Windows + R`, type `cmd`, and press Enter
   - In the Command Prompt, type:
   ```bash
   java --version
   ```
   - You should see something like: `openjdk 17.0.x`
   - Also run:
   ```bash
   javac --version
   ```
   - You should see the same version number

### macOS
1. **Option 1 - Homebrew (Recommended):**
   
   **What is Homebrew?**
   Homebrew is a package manager for macOS that makes it easy to install software from the command line.
   
   **First, install Homebrew if you don't have it:**
   - Open Terminal (press `Cmd + Space`, type "Terminal", press Enter)
   - Copy and paste this command:
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```
   - Press Enter and wait for the installation to complete
   - You may be asked to enter your password
   - Follow any additional instructions that appear
   
   **Then install Java:**
   ```bash
   brew install --cask temurin
   ```
   - Wait for the download and installation to complete
   
2. **Option 2 - Manual Installation:**
   - Visit [Eclipse Temurin](https://adoptium.net/)
   - Click on "Latest LTS Release"
   - Select "macOS x64" from the dropdown
   - Download the `.pkg` installer file
   - Double-click the downloaded file
   - Follow the installation wizard (click "Continue" and "Install")
   - You may need to enter your password

3. **Verify Installation:**
   - Open Terminal (if not already open)
   - Type:
   ```bash
   java --version
   ```
   - You should see something like: `openjdk 17.0.x`
   - Also run:
   ```bash
   javac --version
   ```
   - You should see the same version number

### Linux (Ubuntu/Debian)
1. **Open Terminal:**
   - Press `Ctrl + Alt + T` to open Terminal
   
2. **Update package list:**
   ```bash
   sudo apt update
   ```
   - Enter your password when prompted
   
3. **Install Java:**
   ```bash
   sudo apt install openjdk-17-jdk
   ```
   - Type `Y` and press Enter when asked to continue
   - Wait for installation to complete

### Linux (Fedora/RHEL/CentOS)
1. **Open Terminal:**
   - Press `Ctrl + Alt + T` or search for "Terminal" in your applications
   
2. **Install Java:**
   ```bash
   sudo dnf install java-17-openjdk-devel
   ```
   - Enter your password when prompted
   - Type `Y` and press Enter when asked to continue
   - Wait for installation to complete

### Verify Linux Installation
For both Linux distributions, verify the installation:
```bash
java --version
javac --version
```

## VS Code Installation

**What is VS Code?**
Visual Studio Code is a free, powerful code editor that makes writing Java programs much easier. It provides features like syntax highlighting, error detection, and debugging tools.

### Download and Install

#### Windows
1. Visit [Visual Studio Code](https://code.visualstudio.com/)
2. Click the big blue "Download for Windows" button
3. Once downloaded, double-click the `.exe` file
4. If Windows asks "Do you want to allow this app to make changes?", click "Yes"
5. Follow the installation wizard:
   - Accept the license agreement
   - Choose installation location (default is fine)
   - Check "Add 'Open with Code' action to Windows Explorer file context menu"
   - Check "Add 'Open with Code' action to Windows Explorer directory context menu"
   - Click "Install"
6. Click "Finish" when installation is complete

#### macOS
1. Visit [Visual Studio Code](https://code.visualstudio.com/)
2. Click the big blue "Download for Mac" button
3. Once downloaded, double-click the `.zip` file
4. Drag the "Visual Studio Code" app to your Applications folder
5. Open VS Code from your Applications folder

#### Linux
1. Visit [Visual Studio Code](https://code.visualstudio.com/)
2. Click the big blue "Download for Linux" button
3. Choose your distribution (Ubuntu, Debian, etc.)
4. Follow the installation instructions for your specific Linux distribution

### First Launch Setup
1. **Launch VS Code:**
   - Windows: Search for "Visual Studio Code" in the Start menu
   - macOS: Open from Applications folder or Spotlight search
   - Linux: Search for "code" in your applications menu

2. **Welcome Screen:**
   - You'll see a welcome screen with various options
   - Click "Get Started" or close the welcome screen

3. **Install Java Extensions (Important!):**
   - Press `Ctrl+Shift+X` (Windows/Linux) or `Cmd+Shift+X` (macOS) to open Extensions
   - Search for "Extension Pack for Java"
   - Click "Install" on the extension by Microsoft
   - This will install multiple Java-related extensions automatically

## Java Extensions

**What are Extensions?**
Extensions add extra features to VS Code. For Java development, we need specific extensions that understand Java syntax and provide helpful tools.

### Essential Extensions
The **Extension Pack for Java** (which you installed in the previous step) includes all of these:

1. **Language Support for Java by Red Hat**
   - **What it does:** Highlights syntax errors, suggests code completions, shows documentation
   - **Why you need it:** Makes writing Java code much easier and catches mistakes

2. **Debugger for Java**
   - **What it does:** Lets you pause your program and inspect variables
   - **Why you need it:** Essential for finding and fixing bugs in your code

3. **Java Test Runner**
   - **What it does:** Runs and displays test results
   - **Why you need it:** Helps you verify your code works correctly

4. **Maven for Java**
   - **What it does:** Manages project dependencies and builds
   - **Why you need it:** Handles complex projects with multiple files and libraries

5. **Project Manager for Java**
   - **What it does:** Organizes your Java projects
   - **Why you need it:** Keeps your code organized as you work on larger projects

### Installing Extensions (Alternative Method)
If you prefer to install extensions individually:

1. Open VS Code
2. Press `Ctrl+Shift+X` (Windows/Linux) or `Cmd+Shift+X` (macOS)
3. Search for each extension by name
4. Click "Install" for each extension

**Note:** The Extension Pack for Java installs all of these automatically, so you don't need to install them separately unless you want to.

## Verify Setup

Now let's make sure everything is working correctly by testing both Java and VS Code.

### Test Java Installation
**This step confirms that Java is properly installed and accessible from the command line.**

1. **Open a terminal/command prompt:**
   - **Windows:** Press `Windows + R`, type `cmd`, press Enter
   - **macOS:** Press `Cmd + Space`, type "Terminal", press Enter
   - **Linux:** Press `Ctrl + Alt + T`

2. **Test Java runtime:**
   ```bash
   java --version
   ```
   - You should see output like: `openjdk 17.0.x` or `java version "17.x.x"`
   - If you see "command not found" or similar, Java is not properly installed

3. **Test Java compiler:**
   ```bash
   javac --version
   ```
   - You should see the same version number as above
   - This confirms both the runtime and compiler are working

### Test VS Code Java Setup
**This step confirms that VS Code can work with Java files and run programs.**

1. **Create a project folder:**
   - Create a new folder on your desktop called "JavaTest"
   - This will be your first Java project

2. **Open the folder in VS Code:**
   - Open VS Code
   - Go to `File → Open Folder` (or press `Ctrl+O` / `Cmd+O`)
   - Navigate to and select your "JavaTest" folder
   - Click "Select Folder"

3. **Create your first Java file:**
   - In VS Code, click the "New File" icon in the Explorer panel (left sidebar)
   - Name the file `HelloWorld.java` (exactly this name, including the `.java` extension)
   - Click on the file to open it

4. **Write your first program:**
   - Copy and paste this code into the file:
   ```java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello, World!");
       }
   }
   ```
   - **Important:** The class name (`HelloWorld`) must match the filename (`HelloWorld.java`)

5. **Save the file:**
   - Press `Ctrl+S` (Windows/Linux) or `Cmd+S` (macOS)
   - Or go to `File → Save`

6. **Run the program:**
   - Press `F5` to run the program
   - VS Code will ask you to select a debugger - choose "Java"
   - You should see "Hello, World!" appear in the Debug Console at the bottom

**Congratulations!** If you see "Hello, World!" in the console, your Java development environment is working perfectly!

## Running Java Code in VS Code

Now that your environment is set up, here are different ways to run your Java programs in VS Code.

### Method 1: Using the Run Button (Easiest)
1. **Open your Java file** in VS Code
2. **Look for the Run button** - it appears as a play button (▶️) in the top-right corner when you have a Java file open
3. **Click the Run button** - VS Code will automatically compile and run your program
4. **View the output** in the Terminal panel at the bottom

### Method 2: Using F5 (Debug Mode)
**This method is great for debugging because you can pause your program and inspect variables.**

1. **Set breakpoints** by clicking in the left margin next to line numbers
   - A red dot will appear indicating a breakpoint
   - Your program will pause when it reaches this line

2. **Press F5** to start debugging
   - VS Code will ask you to select a debugger - choose "Java"
   - Your program will run until it hits a breakpoint

3. **Use the debug toolbar** to control execution:
   - **Continue (F5):** Continue running until next breakpoint
   - **Step Over (F10):** Execute current line and move to next
   - **Step Into (F11):** Step into method calls
   - **Step Out (Shift+F11):** Step out of current method

### Method 3: Using Terminal (Traditional Method)
**This method shows you exactly what's happening behind the scenes.**

1. **Open the integrated terminal:**
   - Press `Ctrl+`` ` (Windows/Linux) or `Cmd+`` ` (macOS)
   - Or go to `Terminal → New Terminal`

2. **Navigate to your project folder** (if not already there):
   ```bash
   cd path/to/your/project
   ```

3. **Compile your Java file:**
   ```bash
   javac HelloWorld.java
   ```
   - This creates a `HelloWorld.class` file

4. **Run the compiled program:**
   ```bash
   java HelloWorld
   ```
   - This executes your program and shows output

### Which Method Should You Use?
- **Method 1 (Run Button):** Best for beginners and quick testing
- **Method 2 (F5 Debug):** Best when you need to find and fix bugs
- **Method 3 (Terminal):** Best for understanding how Java compilation works

## Debugging Java Code

**What is Debugging?**
Debugging is the process of finding and fixing errors (bugs) in your code. VS Code provides powerful debugging tools that let you pause your program, inspect variables, and step through code line by line.

### Setting Breakpoints
**Breakpoints tell your program to pause at specific lines so you can examine what's happening.**

1. **Click in the left margin** next to the line number where you want to pause
2. **A red dot will appear** indicating a breakpoint
3. **Press F5** to start debugging
4. **Your program will pause** when it reaches the breakpoint

**Example:** If you want to see what happens when your program prints "Hello, World!", set a breakpoint on that line.

### Debug Controls
When your program is paused at a breakpoint, you'll see a debug toolbar with these controls:

- **Continue (F5):** Continue running until the next breakpoint
- **Step Over (F10):** Execute the current line and move to the next line
- **Step Into (F11):** If the current line calls a method, step into that method
- **Step Out (Shift+F11):** Step out of the current method back to the calling line
- **Restart (Ctrl+Shift+F5):** Restart the debugging session from the beginning
- **Stop (Shift+F5):** Stop debugging and exit the program

### Debug Console
The Debug Console (usually at the bottom) shows:

- **Variable values:** See what values your variables contain
- **Output:** Any text your program prints
- **Error messages:** If something goes wrong

### Debugging Example
Let's debug a simple program:

```java
public class DebugExample {
    public static void main(String[] args) {
        String name = "Alice";
        int age = 25;
        
        System.out.println("Hello, " + name);  // Set breakpoint here
        System.out.println("You are " + age + " years old");
    }
}
```

1. **Set a breakpoint** on the line with `System.out.println("Hello, " + name);`
2. **Press F5** to start debugging
3. **When the program pauses:**
   - Look at the Variables panel on the left
   - You'll see `name = "Alice"` and `age = 25`
   - Use Step Over (F10) to execute the line and see the output
   - Continue stepping to see how the program progresses

### Why Debugging is Important
- **Find errors quickly:** Instead of guessing what's wrong, you can see exactly what's happening
- **Understand your code:** Step through your program to see how it works
- **Test your logic:** Verify that your variables contain the expected values

## Troubleshooting

Even with the best setup, you might encounter some issues. Here are solutions to common problems:

### Common Issues

#### Java not found
**Symptoms:** You get "command not found" when running `java --version`

**Solutions:**
1. **Restart your computer** after installing Java
2. **Check if Java is installed:**
   - Windows: Look in `C:\Program Files\Java\` or `C:\Program Files\Eclipse Adoptium\`
   - macOS: Run `ls /Library/Java/JavaVirtualMachines/`
   - Linux: Run `which java`

3. **Add Java to PATH (Windows):**
   - Search for "Environment Variables" in Windows settings
   - Click "Environment Variables"
   - Under "System Variables", find "Path" and click "Edit"
   - Add the path to your Java installation (e.g., `C:\Program Files\Eclipse Adoptium\jdk-17.x.x\bin`)
   - Restart Command Prompt

#### Extensions not working
**Symptoms:** Java syntax highlighting doesn't work, or you get errors about Java extensions

**Solutions:**
1. **Reload VS Code:**
   - Press `Ctrl+Shift+P` (Windows/Linux) or `Cmd+Shift+P` (macOS)
   - Type "Developer: Reload Window" and press Enter

2. **Check extension installation:**
   - Press `Ctrl+Shift+X` to open Extensions
   - Search for "Extension Pack for Java"
   - Make sure it shows "Installed" and not "Install"

3. **Update VS Code:**
   - Go to `Help → Check for Updates`
   - Install any available updates

#### Compilation errors
**Symptoms:** Your program won't compile or run

**Common causes and solutions:**
1. **Syntax errors:**
   - Check for missing semicolons (`;`)
   - Ensure all brackets `{}` are properly matched
   - Check that class name matches filename exactly

2. **File extension:**
   - Make sure your file ends with `.java`
   - Example: `HelloWorld.java` not `HelloWorld.txt`

3. **Class name mismatch:**
   - If your file is named `HelloWorld.java`, the class must be named `HelloWorld`
   - Java is case-sensitive!

#### Program runs but shows wrong output
**Symptoms:** Your program runs but doesn't do what you expect

**Solutions:**
1. **Use debugging:** Set breakpoints and step through your code
2. **Check your logic:** Make sure your code does what you think it does
3. **Add print statements:** Use `System.out.println()` to see what's happening

### Getting Help

If you're still having trouble:

1. **Check the documentation:**
   - [VS Code Java documentation](https://code.visualstudio.com/docs/languages/java)
   - [Java Extension Pack page](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
   - [Eclipse Temurin documentation](https://adoptium.net/docs/)

2. **Search online:**
   - Copy the exact error message into a search engine
   - Add "Java VS Code" to your search terms

3. **Ask for help:**
   - Check if your issue is already answered in the documentation
   - Be specific about your operating system and Java version
   - Include the exact error message you're seeing

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


*This setup guide is designed for this repo but can be used by anyone learning Java development.*