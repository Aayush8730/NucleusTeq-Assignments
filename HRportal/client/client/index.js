const loginForm = document.getElementById("loginForm");
const loginContainer = document.querySelector(".login-container");
const portalPage = document.getElementById("portalPage");
const errorDiv = document.getElementById("error");

loginForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value.trim();

  const response = await fetch("http://localhost:8091/employees/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, password })
  });

  if (response.ok) {
    const text = await response.text();
    if (text === "HR") {
      loginContainer.style.display = "none";
      portalPage.style.display = "block";
      fetchEmployees();
    } else {
      errorDiv.textContent = "Access Denied.";
    }
  } else if (response.status === 401) {
    alert("Enter valid HR credentials!!")
  }
});

async function fetchEmployees() {
  const response = await fetch("http://localhost:8091/employees");
  const data = await response.json();
  const tableBody = document.querySelector("#employeeTable tbody");
  tableBody.innerHTML = "";

  data.forEach(emp => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${emp.id}</td>
      <td>${emp.name}</td>
      <td>${emp.department}</td>
      <td>${emp.email}</td>
      <td>${emp.salary}</td>
      <td>
        <button onclick='editEmployee(${JSON.stringify(emp)})'>Edit</button>
        <button onclick='deleteEmployee(${emp.id})'>Delete</button>
      </td>
    `;
    tableBody.appendChild(row);
  });
}

document.getElementById("employeeForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const id = document.getElementById("employeeId").value;
  const name = document.getElementById("name").value;
  const department = document.getElementById("department").value;
  const email = document.getElementById("empEmail").value;
  const salary = document.getElementById("salary").value;

  const payload = { name, department, email, salary };

  const url = id ? `http://localhost:8091/employees/${id}` : "http://localhost:8091/employees";
  const method = id ? "PUT" : "POST";

  await fetch(url, {
    method,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(payload),
  });

  document.getElementById("employeeForm").reset();
  document.getElementById("employeeId").value = "";
  fetchEmployees();
});

function editEmployee(emp) {
  document.getElementById("employeeId").value = emp.id;
  document.getElementById("name").value = emp.name;
  document.getElementById("department").value = emp.department;
  document.getElementById("empEmail").value = emp.email;
  document.getElementById("salary").value = emp.salary;
}

async function deleteEmployee(id) {
  await fetch(`http://localhost:8091/employees/${id}`, { method: "DELETE" });
  fetchEmployees();
}