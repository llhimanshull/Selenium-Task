# 🧪 Selenium Task Automation Framework

A Java-based automation framework built with Selenium WebDriver and TestNG, designed for efficient browser automation and scalable testing using Maven.

---

## 🚀 Features

- 🔍 Browser automation using Selenium WebDriver  
- ✅ Test execution powered by TestNG  
- 📦 Maven-based project for easy dependency management  
- 🔄 Driver management with WebDriverManager  
- 📊 Data-driven testing via Excel file integration (Apache POI)  
- 🔧 Easily extendable and maintainable project structure  

---

## 🛠️ Tech Stack

| Technology         | Purpose                          |
|--------------------|----------------------------------|
| Java               | Core programming language        |
| Selenium WebDriver | Browser automation               |
| TestNG             | Testing framework                |
| WebDriverManager   | Auto driver management           |
| Apache POI         | Excel-based data support         |
| Maven              | Build and dependency manager     |

---

## 📦 Project Structure

```
demo/
├── src/
│   └── test/
│       └── java/
│           └── (Test classes here)
├── pom.xml
```

---

## ▶️ How to Run the Tests

1. Clone the repository:

   ```bash
   git clone https://github.com/llhimanshull/Selenium-Task.git
   cd Selenium-Task
   ```

2. Run tests using Maven:

   ```bash
   mvn clean test
   ```

3. Reports and logs will be generated in the `target` folder.

---

## 📊 Test Data

This project supports Excel-based data-driven testing using Apache POI.  
Place your Excel test files in a dedicated `/resources` folder and configure the file paths in your utility classes.

---

## 📸 Screenshots

> *(Add screenshots of your test execution, browser actions, or report folders here)*

---

## 👨‍💻 Author

**Himanshu Chandekar**  
[🔗 GitHub](https://github.com/llhimanshull)

---

## 📝 License

This project is licensed under the **MIT License** – see the [LICENSE.md](LICENSE.md) file for details.

---

## 🤝 Contributions

Feel free to **fork the repo** and submit **pull requests** to improve or extend the test framework.
