import csv
from datetime import datetime
import matplotlib.pyplot as plt
from collections import defaultdict

FILE_NAME = "expenses.csv"


def init_file():
    try:
        with open(FILE_NAME, 'x', newline='') as file:
            writer = csv.writer(file)
            writer.writerow(["Date", "Category", "Amount", "Description"])
    except FileExistsError:
        pass



def add_expense():
    date = input("Enter date (YYYY-MM-DD) or press Enter for today: ")
    if date == "":
        date = datetime.now().strftime("%Y-%m-%d")

    category = input("Enter category (Food/Travel/Bills/Others): ")
    amount = float(input("Enter amount: "))
    description = input("Enter description: ")

    with open(FILE_NAME, 'a', newline='') as file:
        writer = csv.writer(file)
        writer.writerow([date, category, amount, description])

    print("✅ Expense added successfully!")



def view_expenses():
    with open(FILE_NAME, 'r') as file:
        reader = csv.reader(file)
        for row in reader:
            print(row)


def monthly_summary():
    month = input("Enter month (YYYY-MM): ")
    total = 0

    with open(FILE_NAME, 'r') as file:
        reader = csv.DictReader(file)
        for row in reader:
            if row["Date"].startswith(month):
                total += float(row["Amount"])

    print(f"📊 Total expense for {month}: ₹{total}")



def category_analysis():
    data = defaultdict(float)

    with open(FILE_NAME, 'r') as file:
        reader = csv.DictReader(file)
        for row in reader:
            data[row["Category"]] += float(row["Amount"])

    if not data:
        print("No data available!")
        return

    # Highest spending category
    max_category = max(data, key=data.get)
    print(f"💸 Highest spending category: {max_category} (₹{data[max_category]})")

    # Pie chart
    plt.pie(data.values(), labels=data.keys(), autopct='%1.1f%%')
    plt.title("Category-wise Expense Distribution")
    plt.show()


# Main menu
def main():
    init_file()

    while True:
        print("\n==== Smart Expense Tracker ====")
        print("1. Add Expense")
        print("2. View Expenses")
        print("3. Monthly Summary")
        print("4. Category Analysis")
        print("5. Exit")

        choice = input("Enter choice: ")

        if choice == '1':
            add_expense()
        elif choice == '2':
            view_expenses()
        elif choice == '3':
            monthly_summary()
        elif choice == '4':
            category_analysis()
        elif choice == '5':
            print("👋 Exiting...")
            break
        else:
            print("Invalid choice!")


if __name__ == "__main__":
    main()