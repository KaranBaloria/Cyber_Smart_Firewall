function sendRequest() {

    const payload = document.getElementById("payload").value;

    fetch("http://localhost:8080/check", {
        method: "POST",
        body: payload
    })
    .then(res => res.text())
    .then(data => {
        const status = document.getElementById("status");
        status.innerText = data;

        if (data === "ALLOWED") {
            status.className = "status allowed";
        } else {
            status.className = "status blocked";
        }
    });
}

// 🔁 Fetch logs every 2 seconds
setInterval(() => {
    fetch("http://localhost:8080/logs")
        .then(res => res.text())
        .then(data => {
            document.getElementById("logs").innerText = data;
        });
}, 2000);
