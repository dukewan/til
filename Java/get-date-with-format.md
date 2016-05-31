# Get Date with Format

+ get today's date with format

```java
LocalDate now = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
String date = now.format(formatter);
System.out.println("today's date: " + date);
```

+ get date with format of 7 days' before

```java
LocalDate now = LocalDate.now();
LocalDate old = now.plusDays(-7);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
String date = old.format(formatter);
System.out.println("old date: " + date);
```
