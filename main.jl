using TerminalMenus

function clear()
    print("\033c")
end

function add(a, b)
    sum = a + b
    return sum
end

function subtract(a, b)
    difference = a - b
    return difference
end

function multiply(a, b)
    product = a * b
    return product
end

function divide(a, b)
    quotient = round(a / b, digits=2)
    return quotient
end

function main()
    clear()
    options = ["Add +", "Subtract -", "Multiply *", "Divide /"]
    menu = RadioMenu(options, pagesize=4)
    choice = request("Choose an operation:", menu)

    clear()
    println("You selected, ", options[choice])
    print("What is the 1st Int? >>> ")
    int1 = parse(Int, readline(stdin))
    print("What is the 2nd Int? >>> ")
    int2 = parse(Int, readline(stdin))
    

    if choice == 1 # add operation
        println("$int1 + $int2 = ", add(int1, int2))
    elseif choice == 2 # subtract operation
        println("$int1 - $int2 = ", subtract(int1, int2))
    elseif choice == 3 # multiply operation
        println("$int1 * $int2 = ", multiply(int1, int2))
    elseif choice == 4 # divide operation
        println("$int1 / $int2 = ", divide(int1, int2))
    else
        println("Cancelled.")
    end
end

main()
