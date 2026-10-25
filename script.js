// Local Database Mock (Stores user credentials and bank logs in browser memory)
let appDatabase = {
    users: [
        { cardno: "5040936000123456", pin: "1234", formno: "1001" }
    ],
    bankTransactions: [
        { pin: "1234", date: new Date().toLocaleString(), mode: "Deposit", amount: "5000" }
    ]
};

// Global State Management
let currentPinSession = "";
let generatedFormNo = Math.floor(1000 + Math.random() * 9000);
let generatedCardNo = "5040" + Math.floor(100000000000 + Math.random() * 900000000000);
let generatedPinCode = Math.floor(1000 + Math.random() * 9000).toString();

// Screen Navigation Utility
function switchScreen(screenId) {
    document.querySelectorAll('.screen').forEach(screen => {
        screen.classList.remove('active');
    });
    document.getElementById(screenId).classList.add('active');
}

// Custom Popup Alert Modal
function showAlert(message, callback) {
    const modal = document.getElementById('custom-modal');
    document.getElementById('modal-message').innerText = message;
    modal.classList.remove('hidden');
    
    const okBtn = document.getElementById('modal-ok');
    // Replace old listeners to prevent stacking
    const newBtn = okBtn.cloneNode(true);
    okBtn.parentNode.replaceChild(newBtn, okBtn);
    
    newBtn.addEventListener('click', () => {
        modal.classList.add('hidden');
        if (callback) callback();
    });
}

// Initialization on DOM Load
document.addEventListener('DOMContentLoaded', () => {
    // Set auto-generated form and card labels
    document.getElementById('form-no-display').innerText = generatedFormNo;
    document.getElementById('form-no-p3').innerText = generatedFormNo;
    document.getElementById('gen-card-no').innerText = generatedCardNo;
    document.getElementById('gen-pin').innerText = generatedPinCode;

    // --- LOGIN SCREEN ACTIONS ---
    document.getElementById('btn-signin').addEventListener('click', () => {
        const cardno = document.getElementById('card-no').value.trim();
        const pin = document.getElementById('pin-no').value.trim();

        const userFound = appDatabase.users.find(u => u.cardno === cardno && u.pin === pin);
        if (userFound || (cardno === "admin" && pin === "1234")) {
            currentPinSession = userFound ? userFound.pin : "1234";
            switchScreen('atm-screen');
        } else {
            showAlert("Incorrect Card Number or PIN");
        }
    });

    document.getElementById('btn-clear').addEventListener('click', () => {
        document.getElementById('card-no').value = '';
        document.getElementById('pin-no').value = '';
    });

    document.getElementById('btn-signup-main').addEventListener('click', () => {
        switchScreen('signup-screen-1');
    });

    // --- SIGN UP PAGE 1 ACTIONS ---
    document.getElementById('btn-su-next').addEventListener('click', () => {
        const name = document.getElementById('su-name').value.trim();
        if (!name) {
            showAlert("Name is required!");
            return;
        }
        switchScreen('signup-screen-3');
    });

    // --- SIGN UP PAGE 3 ACTIONS ---
    document.getElementById('btn-submit-acc').addEventListener('click', () => {
        const selectedAccTypeRadio = document.querySelector('input[name="acc-type"]:checked');
        const accountType = selectedAccTypeRadio ? selectedAccTypeRadio.value : "Saving Account";

        // Save new user profile and credentials to mock DB
        appDatabase.users.push({
            cardno: generatedCardNo,
            pin: generatedPinCode,
            formno: generatedFormNo.toString()
        });

        showAlert(`Account Created Successfully!\nCard Number: ${generatedCardNo}\nPIN: ${generatedPinCode}`, () => {
            switchScreen('login-screen');
        });
    });

    document.getElementById('btn-cancel-acc').addEventListener('click', () => {
        switchScreen('login-screen');
    });

    // --- ATM MAIN DASHBOARD ACTIONS ---
    document.getElementById('trans-deposit').addEventListener('click', () => {
        document.getElementById('deposit-amount').value = '';
        switchScreen('deposit-screen');
    });

    document.getElementById('trans-withdraw').addEventListener('click', () => {
        switchScreen('fastcash-screen'); // Reusing cash window for withdrawal amount selections
    });

    document.getElementById('trans-cash').addEventListener('click', () => {
        switchScreen('fastcash-screen');
    });

    document.getElementById('trans-statement').addEventListener('click', () => {
        renderMiniStatement();
        switchScreen('ministatement-screen');
    });

    document.getElementById('trans-balance').addEventListener('click', () => {
        let balance = calculateBalance(currentPinSession);
        showAlert(`Your current balance is Rs ${balance}`);
    });

    document.getElementById('trans-exit').addEventListener('click', () => {
        switchScreen('login-screen');
    });

    // --- DEPOSIT ACTIONS ---
    document.getElementById('btn-confirm-deposit').addEventListener('click', () => {
        const amount = document.getElementById('deposit-amount').value.trim();
        if (!amount || Number(amount) <= 0) {
            showAlert("Please enter a valid amount to deposit");
            return;
        }

        appDatabase.bankTransactions.push({
            pin: currentPinSession,
            date: new Date().toLocaleString(),
            mode: "Deposit",
            amount: amount
        });

        showAlert(`Rs. ${amount} Deposited Successfully`, () => {
            switchScreen('atm-screen');
        });
    });

    document.getElementById('btn-back-deposit').addEventListener('click', () => {
        switchScreen('atm-screen');
    });

    // --- FAST CASH BUTTONS ---
    document.querySelectorAll('.fc-btn').forEach(button => {
        button.addEventListener('click', (e) => {
            const amount = e.target.getAttribute('data-amt');
            let balance = calculateBalance(currentPinSession);

            if (balance < Number(amount)) {
                showAlert("Insufficient Balance");
                return;
            }

            appDatabase.bankTransactions.push({
                pin: currentPinSession,
                date: new Date().toLocaleString(),
                mode: "Withdrawal",
                amount: amount
            });

            showAlert(`Rs. ${amount} Debited Successfully`, () => {
                switchScreen('atm-screen');
            });
        });
    });

    document.getElementById('btn-back-fastcash').addEventListener('click', () => {
        switchScreen('atm-screen');
    });

    // --- MINI STATEMENT EXIT ---
    document.getElementById('btn-exit-statement').addEventListener('click', () => {
        switchScreen('atm-screen');
    });
});

// Helper Function: Compute Balance from Transactions
function calculateBalance(pin) {
    let balance = 0;
    const userTransactions = appDatabase.bankTransactions.filter(t => t.pin === pin || t.pin === "1234");
    userTransactions.forEach(tx => {
        if (tx.mode === "Deposit") {
            balance += Number(tx.amount);
        } else {
            balance -= Number(tx.amount);
        }
    });
    return balance;
}

// Helper Function: Render Mini Statement Log
function renderMiniStatement() {
    const listContainer = document.getElementById('ms-transactions-list');
    listContainer.innerHTML = "";

    const userObj = appDatabase.users.find(u => u.pin === currentPinSession) || { cardno: "5040936000123456" };
    const maskedCard = userObj.cardno.substring(0, 4) + "XXXXXXXX" + userObj.cardno.substring(12);
    document.getElementById('ms-cardno').innerText = "Card Number: " + maskedCard;

    let balance = 0;
    const userTransactions = appDatabase.bankTransactions.filter(t => t.pin === currentPinSession || t.pin === "1234");
    
    userTransactions.forEach(tx => {
        const item = document.createElement('div');
        item.className = 'transaction-item';
        item.innerHTML = `<span>${tx.date}</span> <span>${tx.mode}</span> <span>Rs. ${tx.amount}</span>`;
        listContainer.appendChild(item);

        if (tx.mode === "Deposit") {
            balance += Number(tx.amount);
        } else {
            balance -= Number(tx.amount);
        }
    });

    document.getElementById('ms-total-balance').innerText = `Your total Balance is Rs ${balance}`;
}