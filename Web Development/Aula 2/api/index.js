import cors from "cors";
import express from "express";

const app = express();

app.use(express.json());
app.use(cors());

app.get("/", (req, res) => {
  return res.json({ message: "Hello GET" });
});

app.post("/", (req, res) => {
  const data = req.body;

  return res.json({ data });
});

app.listen(3333, () => {
  console.log("Server is running on port 3333 🚀");
});
