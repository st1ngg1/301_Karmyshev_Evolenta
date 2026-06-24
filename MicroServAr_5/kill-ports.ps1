# Освобождает порты 8080, 8081, 8082 перед запуском сервисов
$ports = 8080, 8081, 8082
foreach ($port in $ports) {
    $connections = Get-NetTCPConnection -LocalPort $port -ErrorAction SilentlyContinue
    foreach ($conn in $connections) {
        if ($conn.OwningProcess -and $conn.OwningProcess -ne 0) {
            Stop-Process -Id $conn.OwningProcess -Force -ErrorAction SilentlyContinue
            Write-Host "Остановлен процесс $($conn.OwningProcess) на порту $port"
        }
    }
}
Write-Host "Порты 8080-8082 свободны."
