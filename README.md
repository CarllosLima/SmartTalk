# SmartTask

SmartTask é um aplicativo Android simples para gerenciamento de tarefas. Ele permite cadastrar tarefas, visualizar a lista, marcar itens como concluídos e excluir tarefas.

O projeto foi desenvolvido como um app Android nativo, usando Kotlin, RecyclerView e persistência local com `SharedPreferences` e Gson.

## Funcionalidades

- Adicionar novas tarefas por meio de um campo de texto.
- Exibir as tarefas em uma lista com `RecyclerView`.
- Marcar ou desmarcar uma tarefa como concluída usando `CheckBox`.
- Excluir tarefas individualmente.
- Salvar a lista de tarefas localmente no dispositivo.

## Tecnologias utilizadas

- Kotlin
- Android SDK
- Gradle Kotlin DSL
- AndroidX AppCompat
- AndroidX Core KTX
- AndroidX Activity KTX
- RecyclerView
- Material Components
- Gson
- SharedPreferences

## Requisitos

Para executar o projeto, tenha instalado:

- Android Studio
- JDK 11 ou superior
- Android SDK compatível com a configuração do projeto
- Emulador ou dispositivo Android com API 25 ou superior

Configurações principais do projeto:

- `minSdk`: 25
- `targetSdk`: 36
- `compileSdk`: 36
- `applicationId`: `com.example.smarttask`
- `versionName`: `1.0`

## Como executar

Clone ou extraia o projeto e abra a pasta `SmartTask` no Android Studio.

Também é possível compilar pelo terminal:

```bash
cd SmartTask
./gradlew assembleDebug
```

No Windows:

```bash
cd SmartTask
gradlew.bat assembleDebug
```

Para instalar em um emulador ou dispositivo conectado:

```bash
./gradlew installDebug
```

O APK de debug gerado ficará em:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Estrutura do projeto

```text
SmartTask/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/com/example/smarttask/
│       │   │   ├── MainActivity.kt
│       │   │   ├── adapter/
│       │   │   │   └── tarefaAdapter.kt
│       │   │   ├── model/
│       │   │   │   └── tarefa.kt
│       │   │   └── utils/
│       │   │       └── Prefs.kt
│       │   └── res/
│       │       ├── layout/
│       │       │   ├── activity_main.xml
│       │       │   └── item_tarefa.xml
│       │       └── values/
│       │           ├── colors.xml
│       │           ├── strings.xml
│       │           └── themes.xml
│       ├── androidTest/
│       └── test/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── gradlew
└── gradlew.bat
```

## Principais arquivos

### `MainActivity.kt`

É a tela principal do aplicativo. Ela:

- Inicializa os componentes da interface.
- Carrega as tarefas salvas.
- Configura o `RecyclerView`.
- Adiciona novas tarefas.
- Remove tarefas quando o botão **Excluir** é pressionado.

### `TarefaAdapter`

É o adapter do `RecyclerView`. Ele liga cada objeto `Tarefa` ao layout `item_tarefa.xml`, exibindo:

- Título da tarefa.
- Caixa de seleção de conclusão.
- Botão de exclusão.

### `Tarefa`

Modelo de dados que representa uma tarefa:

```kotlin
data class Tarefa(
    var titulo: String,
    var concluida: Boolean = false
)
```

### `Prefs`

Classe responsável por salvar e carregar a lista de tarefas usando `SharedPreferences`. A lista é convertida para JSON com Gson antes de ser armazenada.

## Persistência de dados

As tarefas são salvas localmente no dispositivo no arquivo de preferências chamado `tarefas`, usando a chave `lista`.

Fluxo básico:

1. O app inicia e chama `prefs.carregar()`.
2. A lista salva é recuperada em formato JSON.
3. O Gson converte o JSON em uma lista de objetos `Tarefa`.
4. Ao adicionar ou excluir uma tarefa, o app chama `prefs.salvar(lista)`.

## Layouts

### `activity_main.xml`

Define a tela principal com:

- Título do app.
- Campo para digitar uma tarefa.
- Botão para adicionar tarefa.
- Lista de tarefas com `RecyclerView`.

### `item_tarefa.xml`

Define o visual de cada item da lista com:

- `CheckBox` para marcar a tarefa como concluída.
- `TextView` para mostrar o título.
- `Button` para excluir a tarefa.

## Testes

Para rodar testes unitários:

```bash
./gradlew test
```

Para rodar testes instrumentados em um dispositivo ou emulador:

```bash
./gradlew connectedAndroidTest
```

## Observações técnicas

- O projeto usa arquivos `.kt`, portanto o ambiente de build precisa estar configurado para Kotlin.
- Atualmente, a lista é salva ao adicionar ou excluir tarefas.
- Uma melhoria recomendada é salvar a lista também quando o usuário marcar ou desmarcar o `CheckBox`, garantindo persistência imediata do estado de conclusão.




