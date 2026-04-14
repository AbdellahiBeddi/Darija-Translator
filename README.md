# Darija Translator — LLM-powered RESTful Web Service

A Jakarta EE REST API that translates text to Moroccan Arabic Dialect (Darija) using Google Gemini.

## Tech Stack
- Jakarta EE 10 / JAX-RS
- Google Gemini 1.5 Flash API
- GlassFish 7
- Maven

## Endpoints
POST /api/translate
- Auth: Basic (admin / admin123)
- Body: { "text": "...", "sourceLang": "English", "targetLang": "Darija" }

## Clients
- Python client: clients/python/client.py
- PHP client: clients/php/client.php