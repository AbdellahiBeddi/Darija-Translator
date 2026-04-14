<?php
$url     = "http://localhost:8080/Darija-Translator/api/translate";
$payload = json_encode([
    "text"       => "Good morning",
    "sourceLang" => "English",
    "targetLang" => "Darija"
]);

$ch = curl_init($url);
curl_setopt_array($ch, [
    CURLOPT_POST           => true,
    CURLOPT_POSTFIELDS     => $payload,
    CURLOPT_RETURNTRANSFER => true,
    CURLOPT_USERPWD        => "admin:admin123",
    CURLOPT_HTTPHEADER     => ["Content-Type: application/json"],
]);

$result = curl_exec($ch);
curl_close($ch);

$data = json_decode($result, true);
echo "Translation: " . $data["translation"];
?>