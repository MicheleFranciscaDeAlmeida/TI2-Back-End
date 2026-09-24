const rotas = {
    entrada: "modulos/entrada/entrada.html",
    login: "modulos/login/login.html",
    perfil: "modulos/perfil/perfil.html",
    planos: "modulos/planos/planos.html"
};


async function carregarModulo(nomeRota) {

    const caminho = rotas[nomeRota];

    if (!caminho) {
        return;
    }

    const resposta = await fetch(caminho);
    const html = await resposta.text();

    document.getElementById("conteudo-principal").innerHTML = html;


    /* =========================
       ENTRADA
       ========================= */

    if (nomeRota === "entrada") {

        const botaoEstudante =
            document.getElementById("btn-estudante");

        const botaoInstituicao =
            document.getElementById("btn-instituicao");


        botaoEstudante.addEventListener("click", function () {

            window.location.hash = "#login";

            carregarModulo("login");

        });


        botaoInstituicao.addEventListener("click", function () {

            alert("Área institucional");

        });

    }


    /* =========================
       PERFIL
       ========================= */

    if (nomeRota === "perfil") {

        configurarPerfil();

    }


    /* =========================
       PLANOS
       ========================= */

    if (nomeRota === "planos") {

        const botaoAssinar =
            document.getElementById("btn-assinar-premium");


        if (botaoAssinar) {

            botaoAssinar.addEventListener("click", function () {

                alert("Plano Premium selecionado!");

            });

        }

    }

}


/* =========================
   CONFIGURAR PERFIL
   ========================= */

function configurarPerfil() {

    const botaoEditar =
        document.getElementById("btn-editar-perfil");


    if (!botaoEditar) {
        return;
    }


    botaoEditar.addEventListener("click", function () {

        const card =
            document.querySelector(".perfil-card");


        card.innerHTML = `

            <h1>Editar Perfil</h1>

            <div class="perfil-edicao">

                <label for="editar-nome">
                    Nome
                </label>

                <input
                    type="text"
                    id="editar-nome"
                    value="Michelli"
                >


                <label for="editar-email">
                    E-mail
                </label>

                <input
                    type="email"
                    id="editar-email"
                    value="estudante@email.com"
                >


                <label for="editar-instituicao">
                    Instituição
                </label>

                <input
                    type="text"
                    id="editar-instituicao"
                    value="Minha instituição"
                >

            </div>


            <button
                class="btn-salvar-perfil"
                id="btn-salvar-perfil">

                Salvar alterações

            </button>

        `;


        document
            .getElementById("btn-salvar-perfil")
            .addEventListener("click", function () {

                const nome =
                    document.getElementById("editar-nome").value;

                const email =
                    document.getElementById("editar-email").value;

                const instituicao =
                    document.getElementById("editar-instituicao").value;


                card.innerHTML = `

                    <h1>Meu Perfil</h1>

                    <div class="perfil-foto">
                        <span>👤</span>
                    </div>

                    <h2 id="perfil-nome">
                        ${nome}
                    </h2>

                    <p>Estudante</p>


                    <div class="perfil-dados">

                        <div class="perfil-campo">

                            <strong>Nome</strong>

                            <span>
                                ${nome}
                            </span>

                        </div>


                        <div class="perfil-campo">

                            <strong>E-mail</strong>

                            <span>
                                ${email}
                            </span>

                        </div>


                        <div class="perfil-campo">

                            <strong>Instituição</strong>

                            <span>
                                ${instituicao}
                            </span>

                        </div>

                    </div>


                    <button id="btn-editar-perfil">
                        Editar perfil
                    </button>

                `;


                configurarPerfil();

            });

    });

}


/* =========================
   ROTA INICIAL
   ========================= */

const rotaAtual =
    window.location.hash.replace("#", "") || "entrada";


carregarModulo(rotaAtual);