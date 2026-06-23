#!/bin/bash
cd "$(dirname "$0")"

# Kill any existing server on port 8080
lsof -ti:8080 | xargs kill -9 2>/dev/null

python3 -m http.server 8080 &
SERVER_PID=$!

sleep 0.5
open "http://localhost:8080/leetcode_interactive.html"

echo "✅ Сервер запущено на http://localhost:8080"
echo "   Натисни Ctrl+C щоб зупинити"

trap "kill $SERVER_PID 2>/dev/null; echo 'Сервер зупинено.'" EXIT
wait $SERVER_PID
