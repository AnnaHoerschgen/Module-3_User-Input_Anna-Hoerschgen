class Book(val title: String, val author: String, val year: Int?) {
    init {
        println("New book added: $title by $author")
    }

    fun printDetails() {
        println("Title: $title")
        println("Author: $author")
        println("Published Year: ${year ?: "Unknown"}") // Elvis operator to handle null year
    }
}

fun main() {
    val books = mutableListOf<Book>()

    while (true) {
        println("\nLibrary Menu:")
        println("1. Add a book")
        println("2. View all books")
        println("3. Find a book by title")
        println("4. Exit")
        print("Enter your choice: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Enter book title: ")
                val title = readLine() ?: "Untitled"

                print("Enter author name: ")
                val author = readLine() ?: "Unknown"

                print("Enter publication year (or press Enter to skip): ")
                val year = readLine()?.toIntOrNull()

                books.add(Book(title, author, year))
            }

            2 -> {
                if (books.isEmpty()) {
                    println("No books in the library yet!")
                } else {
                    println("\nAvailable Books:")
                    for (book in books) {
                        book.printDetails()
                        println()
                    }
                }
            }

            3 -> {
                print("Enter book title to search: ")
                val searchTitle = readLine()
                val book = books.find { it.title.equals(searchTitle, ignoreCase = true) }
                book?.printDetails() ?: println("Book not found!")
            }

            4 -> {
                println("Exiting program. Goodbye!")
                break
            }

            else -> println("Invalid choice. Please enter a number between 1 and 4.")
        }
    }
}
