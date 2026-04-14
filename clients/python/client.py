import requests

url  = "http://localhost:8080/Darija-Translator/api/translate"
auth = ("admin", "admin123")

payload = {
    "text": "Hello, how are you?",
    "sourceLang": "English",
    "targetLang": "Darija"
}

response = requests.post(url, json=payload, auth=auth)

if response.status_code == 200:
    print("Translation:", response.json()["translation"])
else:
    print("Error:", response.status_code, response.text)