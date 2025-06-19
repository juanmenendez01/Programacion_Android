using System;
using System.Collections.Generic;

namespace ApiAndroid.Models;

public partial class Notum
{
    public int IdNota { get; set; }

    public int? IdEstudiante { get; set; }

    public decimal? NotaFinal { get; set; }

    public virtual Estudiante? IdEstudianteNavigation { get; set; }
}
