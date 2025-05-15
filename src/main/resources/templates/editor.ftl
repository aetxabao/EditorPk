<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/estilo.css">
</head>
<body>
<h1>${mapa.nombre}</h1>
<div id="contenedor">
    <div id="tablero">
        <#list 0..39 as i>
            <#list 0..29 as j>
                <div class="celda" data-fila="${i}" data-columna="${j}"></div>
            </#list>
        </#list>
    </div>
    <div id="escenario">
        <h2>Escenario</h2>
        <div class="horizontal">
            <div id="tierra" class="celda pintura selected" onclick="elegirPintura(this,true,0)"></div><h3>Tierra (0)</h3>
        </div>
        <div class="horizontal">
            <div id="inicio" class="celda pintura" onclick="elegirPintura(this,true,1)"></div><h3>Inicio (1)</h3>
        </div>
        <div class="horizontal">
            <div id="fin" class="celda pintura" onclick="elegirPintura(this,true,2)"></div><h3>Fin (2)</h3>
        </div>
        <div class="horizontal">
            <div id="agua" class="celda pintura" onclick="elegirPintura(this,true,3)"></div><h3>Agua (3)</h3>
        </div>
        <div class="horizontal">
            <div id="pared" class="celda pintura" onclick="elegirPintura(this,true,4)"></div><h3>Pared (4)</h3>
        </div>
    </div>
    <div id="elementos">
        <h2>Elementos</h2>
        <div class="horizontal">
            <div id="borrar" class="celda pintura" onclick="elegirPintura(this,false,0)"></div><h3>Borrar (0)</h3>
        </div>
        <div class="horizontal">
            <div id="bomba" class="celda pintura" onclick="elegirPintura(this,false,1)"></div><h3>Bomba (1)</h3>
        </div>
        <div class="horizontal">
            <div id="oso" class="celda pintura" onclick="elegirPintura(this,false,2)"></div><h3>Oso (2)</h3>
        </div>
        <div class="horizontal">
            <div id="satelite" class="celda pintura" onclick="elegirPintura(this,false,3)"></div><h3>Satelite (3)</h3>
        </div>
        <div class="horizontal">
            <div id="tower" class="celda pintura" onclick="elegirPintura(this,false,4)"></div><h3>Tower (4)</h3>
        </div>
        <div class="horizontal">
            <div id="bunny" class="celda pintura" onclick="elegirPintura(this,false,5)"></div><h3>Bunny (5)</h3>
        </div>
        <div class="horizontal">
            <div id="ammunition5" class="celda pintura" onclick="elegirPintura(this,false,6)"></div><h3>Munición 5 (6)</h3>
        </div>
        <div class="horizontal">
            <div id="ammunition10" class="celda pintura" onclick="elegirPintura(this,false,7)"></div><h3>Munición 10 (7)</h3>
        </div>
        <div class="horizontal">
            <div id="crossgun" class="celda pintura" onclick="elegirPintura(this,false,8)"></div><h3>Crossgun (8)</h3>
        </div>
    </div>
    <div id="acciones">
        <h2>Acciones</h2>
        <form id="formulario">
            <input type="hidden" id="idMapa" name="idMapa" value="${mapa.id}">
            <select id="nivel" name="nivel" size="10">
                <#list mapas as map>
                    <option value="${map.id}">${map.nombre}</option>
                </#list>
            </select>
            <div class="barra-horizontal">
                <button class="btn btn-lg" type="button" id="nuevo">Nuevo</button>
            </div>
            <div class="barra-horizontal">
                <button class="btn btn-lg" type="button" id="borrar">Borrar</button>
            </div>
            <div class="barra-horizontal">
                <button class="btn btn-lg" type="button" id="cargar">Cargar</button>
            </div>
            <div class="barra-horizontal">
                <button class="btn btn-lg" type="button" id="guardar">Guardar</button>
            </div>

        </form>
    </div>
</div>
<script>
    const FILAS = 40;
    const COLUMNAS = 30;

    const surfaces = [${mapa.surfacesArray()}];
    const elements = [${mapa.elementsArray()}];

    const colsSurfaces = [   '#E4AD86',
        '#4CAF50',
        '#FF5733',
        '#1E90FF',
        '#777'];
    const valsSurfaces = [   '0', //tierra
        '1', //inicio
        '2', //fin
        '3', //agua
        '4'];//pared
    const imgsElements = [   '',
        'bomb.png',
        'bear.png',
        'satelite.png',
        'tower_.png',
        'bunny_Right.png',
        'ammunition5.png',
        'ammunition10.png',
        'crossgun.png'];
    const valsElements = [   'S',
        'B',
        'X',
        'T',
        'F',
        'a',
        'A',
        '+'];
    let isMouseDown = false;
    let isSuperficie = true;
    let idx = 0; // Tierra

    {
        for(let i=0; i<FILAS; i++) {
            for(let j=0; j<COLUMNAS; j++) {
                let celda = document
                    .querySelector(".celda[data-fila='"+i+"'][data-columna='"+j+"']");
                if (celda) {
                    let pos = i*COLUMNAS+j;

                    // valor de la superficie en la posición
                    let vsp = surfaces[pos];
                    // posición de ese valor en el array valsSurfaces
                    let pvs = valsSurfaces.indexOf(vsp);
                    if (pvs >= 0) {
                        // color en colsSurfaces en esa posición
                        let color = colsSurfaces[pvs];
                        celda.style.backgroundColor = color;
                    }

                    // valor del elemento en la posición
                    let vep = elements[pos];
                    // posición de ese valor en el array valsElements
                    let pve = valsElements.indexOf(vep);
                    if (pve >= 0) {
                        // imagen en imgsElements en esa posición
                        let imagen = imgsElements[pve];
                        celda.style.backgroundImage = "url('/img/" + imagen + "')";
                    }
                }
            }
        }
    }

    document.querySelectorAll('#nivel option')
        .forEach( opt => {
            opt.addEventListener('dblclick', (e) => {
                const select = document.getElementById('nivel');
                let txt = select.options[select.selectedIndex].text;
                console.log(txt);
                let v = confirm("Quieres cambiar a " + txt +"?" +
                "\nLos cambios no guardados se perderán.");
                if (v) {
                    const form = document.getElementById("formulario");
                    form.action = "seleccionar";
                    form.method = "GET";
                    form.submit();
                }
            });
        });

    document.querySelector('#guardar')
        .addEventListener('click', (e) => {
        e.preventDefault();
        const idMapa = document.getElementById('idMapa').value;
        fetch("guardar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({idMapa, surfaces, elements})
        })
        .then(data => {
            console.log(data);
            alert("Datos guardados");
        })
        .catch(error => {
            console.error("Error: " + error.message);
        });
    });

    document.addEventListener('mouseup', (e) => {
        isMouseDown = false;
    });

    document.querySelectorAll('#tablero .celda')
        .forEach( celda => {
                celda.addEventListener('mousedown', (e) => {
                    console.log('mousedown');
                    isMouseDown = true;
                    pintarCelda(celda);
                });
                celda.addEventListener('mouseover', (e) => {
                    console.log('mouseover');
                    if (isMouseDown) {
                        pintarCelda(celda);
                    }
                })
                celda.addEventListener('mouseup', (e) => {
                    isMouseDown = false;
                    console.log('mouseup isMouseDown=' + isMouseDown);
                })
            }
        );

    function pintarCelda(celda) {
        const fila = parseInt(celda.dataset.fila);
        const columna = parseInt(celda.dataset.columna);
        const pos = COLUMNAS*fila + columna;
        //console.log("fila: " + fila + ", columna: " + columna);
        if (isSuperficie) {
            celda.style.backgroundColor = colsSurfaces[idx];
            surfaces[pos] = valsSurfaces[idx];
        }else{
            celda.style.backgroundImage = "url('/img/" + imgsElements[idx] + "')";
            elements[pos] = valsElements[idx];
        }
    }

    function elegirPintura(elemento, superficie, indice) {
        document.querySelectorAll('.pintura')
            .forEach(celda => {
                celda.classList.remove('selected');
            });
        elemento.classList.add('selected');
        isSuperficie = superficie;
        idx = indice;
        console.log("idx="+idx);
    }

</script>
</body>
</html>
