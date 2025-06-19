using System;
using System.Collections.Generic;

namespace ApiAndroid.Models;

public partial class Admin
{
    public int Id { get; set; }

    public string Nombre { get; set; } = null!;

    public string Correo { get; set; } = null!;

    public string Contrasena { get; set; } = null!;
}
