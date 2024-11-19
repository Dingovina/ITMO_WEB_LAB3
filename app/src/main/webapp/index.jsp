<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="app.models.Point" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">

    <script src="js/jquery-3.7.1.min.js"></script>
    <script src="js/sweetalert2.all.min.js"></script>
    <script src="https://kit.fontawesome.com/e42952d0e5.js" crossorigin="anonymous"></script>
    <script type="module" src="js/main.js"></script>

    <title>Coordinate Axis</title>

</head>
<body>
    <div>
        <nav id="shapka" class="navbar">
            <div class="container-fluid">
                <a class="nav justify-content-start">Вариант 4389</a>
                <a class="nav justify-content-center">Кортыш Константин Олегович</a>
                <a class="nav justify-content-end">Группа P3218</a>
            </div>
        </nav>
    </div>
    <div class="row justify-content-evenly">
        <div class="col-4">
            <div>
                <canvas id="canvas">
                </canvas>
            </div>

            <div>
                <form id="form" class="needs-validation" novalidate >
                    <div class="row justify-content-evenly">
                        <div class="col-1">
                            <label for="x" class="form-label">X:</label>
                        </div>
                        <div class="col-1">
                            <input class="form-check-input" type="checkbox" id="x-2" name="x" value="-2">
                            <label for="x-2">-2.0</label>
                        </div>
                        <div class="col-1">
                            <input class="form-check-input" type="checkbox" id="x-1.5" name="x" value="-1.5">
                            <label for="x-1.5">-1.5</label>
                        </div>
                        <div class="col-1">
                            <input class="form-check-input" type="checkbox" id="x-1" name="x" value="-1">
                            <label for="x-1">-1.0</label>
                        </div>
                        <div class="col-1">
                            <input class="form-check-input" type="checkbox" id="x-0.5" name="x" value="-0.5">
                            <label for="x-0.5">-0.5</label>
                        </div>
                        <div class="col-1">
                            <input class="form-check-input" type="checkbox" id="x0" name="x" value="0" checked>
                            <label for="x0">0.0</label>
                        </div>
                        <div class="col-1">
                            <input class="form-check-input" type="checkbox" id="x0.5" name="x" value="0.5">
                            <label for="x0.5">0.5</label>
                        </div>
                        <div class="col-1">
                            <input class="form-check-input" type="checkbox" id="x1" name="x" value="1">
                            <label for="x1">1.0</label>
                        </div>
                        <div class="col-1">
                            <input class="form-check-input" type="checkbox" id="x1.5" name="x" value="1.5">
                            <label for="x1.5">1.5</label>
                        </div>
                        <div class="col-1">
                            <input class="form-check-input" type="checkbox" id="x2" name="x" value="2">
                            <label for="x2">2.0</label>
                        </div>
                    </div>
                    <div class="row text-center justify-content-around align-items-center">
                        <div class="col-5">
                            <label for="y" class="form-label">Y:</label>
                            <input type="number" id="y" class="form-control" name="y" step="any" min="-3" max="5" required>
                        </div>
                        <div class="col-5">
                            <label for="r" class="form-label">R:</label>
                            <input type="number" class="form-control" id="r" name="r" step="any" min="1" max="4" required>
                        </div>
                        <div class="col-2">
                            <button id="submit_point" type="submit" class="btn btn-success" ><i class="fa-solid fa-crosshairs"></i></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-7">
            <table id="history-table" class="table">
                <thead>
                <tr>
                    <th scope="col">X</th>
                    <th scope="col">Y</th>
                    <th scope="col">R</th>
                    <th scope="col">Результат</th>
                    <th scope="col">Дата и время</th>
                    <th scope="col">Время работы скрипта</th>
                    <th scope="col"><button id="update-history" class="btn btn-secondary">  <i class="fa-solid fa-arrows-rotate"></i></button></th>
                </tr>
                </thead>
                <tbody id="history-table-body">
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
