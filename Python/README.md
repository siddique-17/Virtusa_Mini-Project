

# 💰 Smart Expense Tracker (Python CLI)

A simple command-line **Expense Tracker** built using Python that helps you record daily expenses, view reports, and visualize category-wise spending with charts.

---

## 🚀 Features

✅ Add and save daily expenses  
✅ View all expenses from the CSV file  
✅ Get monthly total expense summary  
✅ Visualize your spending by category (Pie Chart)  
✅ Automatically creates `expenses.csv` on first run  

---

## 🧰 Technologies Used

- **Python 3**
- **CSV module** (for data storage)
- **Matplotlib** (for charts and visualization)
- **Datetime** (to handle date and time)

---

## 📦 Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/siddique-17/SmartExpenseTracker.git
   cd smart-expense-tracker
   ```

2. **Install required packages**

   ```bash
   pip install matplotlib
   ```

3. **Run the program**

   ```bash
   python expense_tracker.py
   ```

---

## 💡 How It Works

When you run the application, you’ll see a menu like this:

```
==== Smart Expense Tracker ====
1. Add Expense
2. View Expenses
3. Monthly Summary
4. Category Analysis
5. Exit
```

### 1️⃣ Add Expense
- Enter the date (or press Enter to use today’s date)
- Choose a category (Food, Travel, Bills, Others)
- Enter amount and description  
The record gets saved in `expenses.csv`.

### 2️⃣ View Expenses
Displays all previous records stored in the CSV file.

### 3️⃣ Monthly Summary
Input a month (e.g., `2024-07`) to view your total spending for that month.

### 4️⃣ Category Analysis
Shows which category you spent the most in and displays a colorful pie chart of spending distribution.

---

## 📊 File Format

The data is stored in a CSV file named `expenses.csv` in the following format:

| Date       | Category | Amount | Description |
|-------------|-----------|--------|--------------|
| 2024-07-12  | Food      | 250    | Lunch at café |
| 2024-07-13  | Travel    | 100    | Bus fare      |

---

## 🧩 Future Enhancements

- Add budget limits and alerts  
- Export reports as PDF  
- Integrate with Google Sheets or Database  
- Add GUI interface  
