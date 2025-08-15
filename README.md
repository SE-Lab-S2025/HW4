# HW4 – BDD-Calculator (SE-Lab-S2025)

**محیط آموزشی:** درس نرم‌افزار مهندسی (SE-Lab)، ترم تابستان 2025

---

## 1. هدف پروژه
در این پروژه با استفاده از **BDD** (Behavior-Driven Development) یک ماشین‌حساب ساده پیاده‌سازی شد که قابلیت انجام عملیات پایه‌ای (جمع، تفریق، ضرب، تقسیم) را دارد. سناریوها و آزمون‌ها با استفاده از **Cucumber (Gherkin)** نوشته شده‌اند تا عملکرد سیستم به‌طور مستقیم از دید کاربر نهایی آزمون شود.

---

## 2. ساختار پروژه
```
.
├── .idea/                # تنظیمات IDE (مثل IntelliJ)
├── src/
│   ├── main/java/...     # پیاده‌سازی منطق ماشین‌حساب
│   ├── test/java/...     # Step Definition ها و کلاس‌های Runner
│   └── test/resources/   # فایل‌های .feature (سناریوهای BDD)
├── pom.xml               # پیکربندی Maven و وابستگی‌ها
└── README.md             # مستندات پروژه
```

---

## 3. وابستگی‌ها (Dependencies)
- **Java**: نسخه 20 یا بالاتر (پیکربندی شده با `maven.compiler.release`)
- **Maven**: ابزار ساخت و مدیریت وابستگی‌ها
- **JUnit 4.13.2**: فریم‌ورک تست
- **Cucumber-JUnit 7.20.1** و **Cucumber-Java 7.20.1**: برای تست مبتنی بر BDD

---

## 4. فرآیند توسعه

توسعه‌ی پروژه بر اساس **BDD** در چند مرحله انجام شد، با تمرکز بر پیاده‌سازی **Step Definition**ها.

### 4.1 تعریف سناریوها (Feature Files)
ابتدا نیازمندی‌ها به شکل سناریوهای قابل‌فهم برای کاربر و ماشین در فایل‌های `.feature` نوشته شدند و در مسیر `src/test/resources` قرار گرفتند.

### 4.2 پیاده‌سازی Step Definition ها
برای هر مرحله (Step) از سناریوها، یک متد در کلاس Step Definition نوشته شد تا عبارات Gherkin به کد جاوا متصل شوند.


### 4.3 پیاده‌سازی منطق برنامه
کلاس `Calculator` در مسیر `src/main/java` ایجاد شد و متدهای مربوط به عملیات ریاضی در آن پیاده‌سازی شدند.
 منطق برنامه همچنین میتواند در مسیر `src/test/java` قرار بگیرد.

### 4.4 اتصال Cucumber به JUnit (Test Runner)
یک کلاس Runner برای اجرای تست‌ها ایجاد شد:
```java
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "stepdefs")
public class RunCucumberTest {
}
```

