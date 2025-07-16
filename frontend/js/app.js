
// document --> Sayfadaki tüm HTML’i temsil eder.
// Yani <html>...</html> içindeki her şey.

document.addEventListener("DOMContentLoaded", function() {
    loadApplications()
}); // Sayfadaki tüm HTML yüklenince → bu kodu çalıştır.

function loadApplications() {
  fetch("http://localhost:8080/api/applications")
    .then(function(response) {
      return response.json();
    })
    .then(function(data) {
      renderApplications(data);
    })
    .catch(function(error) {
      console.error("Hata oldu:", error);
    });
}

function renderApplications(applications) {
  var appDiv = document.getElementById("app");

  var html = "<ul>";

  for (var i = 0; i < applications.length; i++) {
    var app = applications[i];

    html += "<li><strong>" + app.companyName + "</strong> - "
      + (app.position || "") +
      " <button onclick='deleteApplication(" + app.id + ")'>Delete</button></li>";
  }

  html += "</ul>";

  appDiv.innerHTML = html;
}

function deleteApplication(id) {
  fetch("http://localhost:8080/api/applications/" + id, {
    method: "DELETE"
  })
  .then(function() {
    location.reload();
  })
  .catch(function(error) {
    console.error("Hata:", error);
  });
}

