using System;
using System.Collections.Generic;

namespace ApiAndroid.Models;

public partial class Estudiante
{
    public int IdEstudiante { get; set; }

    public string? NombreEstudiante { get; set; }

    public string? ProgramaEstudiante { get; set; }

    public virtual ICollection<Notum> Nota { get; set; } = new List<Notum>();
}
