import { initAI, startCamera, stopCamera } from "./src/ai/fatigueDetector.js";

const viewport = document.getElementById("app-viewport");
let shiftTimerInterval = null;
let shiftStartTime = null;

// Enrutador centralizado
export async function navigateTo(viewName) {
  try {
    // Si dejamos de monitorear, apagar cámara
    if (viewName !== "monitoreo") {
      stopCamera();
      if (shiftTimerInterval && viewName !== "fin-turno") {
        clearInterval(shiftTimerInterval);
      }
    }

    const response = await fetch(`views/${viewName}.html`);
    if (!response.ok) throw new Error(`HTTP ${response.status}`);
    
    viewport.innerHTML = await response.text();
    bindEvents(viewName);
  } catch (err) {
    console.error(`Error al cargar views/${viewName}.html:`, err);
    viewport.innerHTML = `
      <div style="padding:2rem;text-align:center;">
        <h3>Error al cargar: views/${viewName}.html</h3>
        <p class="text-muted">Asegúrate de que el archivo exista en la carpeta views/</p>
      </div>`;
  }
}

function bindEvents(viewName) {
  // 1. LOGIN
  if (viewName === "login") {
    let role = "conductor";
    const btnCond = document.getElementById("btnRoleConductor");
    const btnSup = document.getElementById("btnRoleSupervisor");
    const form = document.getElementById("formLogin");

    btnCond?.addEventListener("click", () => {
      role = "conductor";
      btnCond.classList.add("active");
      btnSup.classList.remove("active");
    });
    btnSup?.addEventListener("click", () => {
      role = "supervisor";
      btnSup.classList.add("active");
      btnCond.classList.remove("active");
    });

    form?.addEventListener("submit", (e) => {
      e.preventDefault();
      if (role === "conductor") navigateTo("onboarding");
      else navigateTo("dashboard-supervisor");
    });
  }

  // 2. ONBOARDING
  if (viewName === "onboarding") {
    document.getElementById("btnOnboardingStart")?.addEventListener("click", () => {
      navigateTo("checklist");
    });
  }

  // 3. CHECKLIST
  if (viewName === "checklist") {
    document.getElementById("btnStartShift")?.addEventListener("click", () => {
      shiftStartTime = new Date();
      navigateTo("monitoreo");
    });
  }

  // 4. CABINA DE MONITOREO
  if (viewName === "monitoreo") {
    initAI();
    startCamera();

    const timerEl = document.getElementById("driveTimer");
    if (timerEl && shiftStartTime) {
      clearInterval(shiftTimerInterval);
      shiftTimerInterval = setInterval(() => {
        const diff = Math.floor((new Date() - shiftStartTime) / 1000);
        const h = Math.floor(diff / 3600).toString().padStart(2, "0");
        const m = Math.floor((diff % 3600) / 60).toString().padStart(2, "0");
        const s = (diff % 60).toString().padStart(2, "0");
        timerEl.innerText = `${h}:${m}:${s}`;
      }, 1000);
    }

    document.getElementById("btnEndShift")?.addEventListener("click", () => {
      navigateTo("fin-turno");
    });
    document.getElementById("btnNavAlertas")?.addEventListener("click", () => {
      navigateTo("alertas-conductor");
    });
    document.getElementById("btnNavAjustes")?.addEventListener("click", () => {
      navigateTo("config-admin");
    });
  }

  // 5. ALERTAS CONDUCTOR
  if (viewName === "alertas-conductor") {
    document.getElementById("btnBackToMonitoreo")?.addEventListener("click", () => {
      navigateTo("monitoreo");
    });
  }

  // 6. FIN DE TURNO
  if (viewName === "fin-turno") {
    document.getElementById("btnEndSession")?.addEventListener("click", () => {
      navigateTo("login");
    });
  }

  // 7. CONFIG ADMIN
  if (viewName === "config-admin") {
    const range = document.getElementById("rangeEar");
    const val = document.getElementById("valEar");
    range?.addEventListener("input", (e) => {
      if (val) val.innerText = e.target.value;
    });
    document.getElementById("btnSaveConfig")?.addEventListener("click", () => {
      navigateTo("monitoreo");
    });
  }

  // 8. SUPERVISOR (Menú lateral)
  document.getElementById("menuDash")?.addEventListener("click", () => navigateTo("dashboard-supervisor"));
  document.getElementById("menuFlota")?.addEventListener("click", () => navigateTo("flota"));
  document.getElementById("menuReportes")?.addEventListener("click", () => navigateTo("reportes"));
  document.getElementById("menuCentroIa")?.addEventListener("click", () => navigateTo("centro-ia"));
  document.getElementById("btnSupervisorLogout")?.addEventListener("click", () => navigateTo("login"));

  if (viewName === "dashboard-supervisor") {
    document.getElementById("btnVerConductor")?.addEventListener("click", () => {
      navigateTo("detalle-conductor");
    });
  }

  if (viewName === "detalle-conductor") {
    document.getElementById("btnVolverDash")?.addEventListener("click", () => {
      navigateTo("dashboard-supervisor");
    });
  }
}

// Iniciar aplicación
navigateTo("login");