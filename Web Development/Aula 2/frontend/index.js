function createRequest() {
  const ajax = new XMLHttpRequest();

  return ajax;
}

function handleHTTPResponse() {
  if (this.readyState === 4) {
    if (this.status === 200) {
      document.querySelector("#unico").innerHTML = this.responseText;
    }
  }
}

function configureRequest(request) {
  request.open("GET", "http:///localhost:3333", true);
  request.setRequestHeader("Content-Type", "application/json");
  request.onreadystatechange = handleHTTPResponse.bind(request);
  request.send();
}

function submitPostRequest(request) {
  request.open("POST", "http:///localhost:3333", true);
  request.setRequestHeader("Content-Type", "application/json");
  request.onreadystatechange = handleHTTPResponse.bind(request);
  request.send(JSON.stringify({ message: "Hello POST" }));
}

function addEventListenerForPost() {
  document.querySelector("button.submit").addEventListener("click", () => {
    const r = createRequest();
    submitPostRequest(r);
  });
}

window.onload = function () {
  const req = createRequest();
  configureRequest(req);
  addEventListenerForPost();
};
