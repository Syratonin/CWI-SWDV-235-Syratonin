@param java.util.Map<String, String> transactions

<div class="transactions">
    <h2>Transactions</h2>

    <ul>
        @for(var transaction : transactions.entrySet())
            <li>
                ${transaction.getKey()}: ${transaction.getValue()}
            </li>
        @endfor
    </ul>
</div>