const messages = [
  ["Title 1", "Text message 1"],
  ["Title 2", "Text message 2"],
];

let index = 0;

function pickMessage() {
  if (index === 1) {
    index = 0;
  } else {
    index = index + 1;
  }

  return messages[index];
}

function nextMessage() {
  let msg = pickMessage();

  document.querySelector("h1").innerHTML = msg[0];
  document.querySelector("p").innerHTML = msg[1];
}
