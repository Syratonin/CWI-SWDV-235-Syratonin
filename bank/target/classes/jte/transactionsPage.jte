@param java.util.Map<String, String> transactions

<!DOCTYPE html>
<html>
<head>
    <title>Transactions</title>
</head>
<body>
    <h1>Transactions</h1>

    <form method="post" action="/transactions">
        <input type="text" name="transaction">
        <button type="submit">Create Transaction</button>
    </form>

    @for(var transaction : transactions.entrySet())
        <div>
            <h2>Transaction ${transaction.getKey()}</h2>
            <p>${transaction.getValue()}</p>

            <form method="post" action="/transactions/${transaction.getKey()}/update">
                <input type="text" name="transaction" value="${transaction.getValue()}">
                <button type="submit">Update Transaction</button>
            </form>

            <form method="post" action="/transactions/${transaction.getKey()}/delete">
                <button type="submit">Delete Transaction</button>
            </form>
        </div>
    @endfor

</body>
</html>