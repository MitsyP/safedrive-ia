# safedrive-ia
Sistema web con IA para reducir la accidentabilidad vial por fatiga en conductores


# SafeDrive IA 🚗💤

Sistema web con Inteligencia Artificial para reducir la accidentabilidad vial por fatiga en los conductores de la Empresa de Transportes San Juan de Lurigancho.

##  Descripción del proyecto

SafeDrive IA es una plataforma web que detecta señales de fatiga en los conductores en tiempo real (mediante visión artificial ejecutada en el navegador) y emite alertas tempranas para prevenir accidentes de tránsito. El sistema cuenta con dos módulos principales:

- **Aplicación del conductor**: registro de turno, monitoreo en vivo del rostro del conductor y alertas de fatiga.
- **Panel del supervisor**: dashboard con el estado de los conductores, historial de alertas e incidentes, y reportes.

El proyecto se desarrolla como parte del curso **Integrador II** de la Facultad de Ingeniería de Sistemas y Software.

## 👥 Integrantes

- Huamán Franco, Julio César
- Paz Mendoza, Mitsy Sharon
- Ulloa Mucha, José Isaac

**Docente:** Effio Gonzales, Carlos
**Sección:** 38356

## 🛠️ Tecnologías utilizadas

| Categoría | Tecnología |
|---|---|
| IDE de desarrollo | Visual Studio Code |
| Control de versiones | Git + GitHub |
| Frontend | HTML, CSS, JavaScript |
| Visión artificial (IA) | MediaPipe Face Mesh (Google), ejecutado en el navegador |
| Backend | Node.js + API REST |
| Base de datos | PostgreSQL |
| Despliegue (hosting) | Render |
| Gestión de proyecto | Trello (tablero Kanban) |

## 📂 Estructura del repositorio

```
safedrive-ia/
├── frontend/       # Interfaz web (conductor y supervisor) + módulo de MediaPipe
├── backend/        # API REST en Node.js
├── evidencias/     # Capturas y video de configuración de herramientas
├── docs/           # Diagramas, prototipos y documentación adicional
└── README.md
```

## ⚙️ Instalación y ejecución local

### Requisitos previos
- [Node.js](https://nodejs.org/) (v18 o superior)
- [PostgreSQL](https://www.postgresql.org/) instalado localmente o una instancia en la nube
- [Git](https://git-scm.com/)

### Pasos

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/MitsyP/safedrive-ia.git
   ```

2. Instalar dependencias del backend:
   ```bash
   cd backend
   npm install
   ```

3. Configurar las variables de entorno (crear un archivo `.env` en `/backend` a partir de `.env.example`):
   ```
   PORT=3000
   DATABASE_URL=postgresql://usuario:password@localhost:5432/safedrive_ia
   ```

4. Levantar el servidor backend:
   ```bash
   npm run dev
   ```

5. Instalar y ejecutar el frontend (en otra terminal):
   ```bash
   cd frontend
   npm install
   npm run dev
   ```

6. Abrir el navegador en `http://localhost:5173` (o el puerto que indique la consola) y permitir el acceso a la cámara para el módulo de detección de fatiga.

## 📌 Tablero Kanban

El seguimiento de tareas y sprints del proyecto se gestiona en Trello:
🔗 [Tablero Kanban - SafeDrive IA](https://trello.com/invite/b/6aa2ce4abcc9199122161b95/ATTI2b60fec7f318aaf92227b4c3b9883d3726E56DDA/safedriveia)

## 📄 Licencia

Proyecto académico desarrollado para el curso Integrador II — uso educativo.
